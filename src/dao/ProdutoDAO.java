package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Categoria;
import model.Fornecedor;
import model.Produto;


public class ProdutoDAO {
	private Connection con = null;

	public ProdutoDAO() {
		con = BancoConnection.getConnection();
	}

	public void inserirProduto(Produto p) {
		String sql = "INSERT INTO tb_produtos (pro_codigo, pro_descricao, pro_valor, pro_quantidade, tb_fornecedores_for_codigo, tb_categoria_cat_codigo) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			stm.setInt(1, p.getCodigo());
			stm.setString(2, p.getDescricao());
			stm.setDouble(3, p.getValor());
			stm.setInt(4, p.getQuantidade());
			stm.setInt(5, p.getFornecedor().getCodigo());
			stm.setInt(6, p.getCategoria().getCodigo());
			
			stm.execute();
			System.out.println("Produto cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		} finally {
			BancoConnection.closeConnection(con);
		}
	}
	
	public Produto achar_produto(int codigo) {
		Produto p = new  Produto();
		String sql = "SELECT * FROM tb_produtos WHERE pro_codigo = ?";
		
		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				p.setCodigo(rs.getInt("pro_codigo"));
				p.setDescricao(rs.getString("pro_descricao"));
				p.setValor(rs.getDouble("pro_valor"));
				p.setQuantidade(rs.getInt("pro_quantidade"));
				//p.setFornecedor((Fornecedor) rs.getObject("tb_fornecedores_for_codigo"));
			//	p.setCategoria((Categoria) rs.getObject("tb_categoria_cat_codigo"));
				
			}
			return p;
		}catch (SQLException ex) {
			System.out.println("Erro: " + ex);
			return null;
		}finally {
			BancoConnection.closeConnection(con);
		}
	}


}
