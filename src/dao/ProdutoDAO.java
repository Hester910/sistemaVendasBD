package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;
import model.Fornecedor;
import model.Item;
import model.Produto;

public class ProdutoDAO {
	private Connection con = null;

	public ProdutoDAO() {
		con = BancoConnection.getConnection();
	}

	public void inserirProduto(Produto p) {
		String sql = "INSERT INTO tb_produtos ( pro_descricao, pro_valor, pro_quantidade, tb_fornecedores_for_codigo, tb_categoria_cat_codigo) VALUES ( ?, ?, ?, ?, ?)";
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			//stm.setInt(1, p.getCodigo());
			stm.setString(1, p.getDescricao());
			stm.setDouble(2, p.getValor());
			stm.setInt(3, p.getQuantidade());
			stm.setInt(4, p.getFornecedor().getCodigo());
			stm.setInt(5, p.getCategoria().getCodigo());

			stm.execute();
			System.out.println("Produto cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		} finally {
			BancoConnection.closeConnection(con);
		}
	}

	public Produto achar_produto(int codigo) {
		Produto p = new Produto();
		String sql = "SELECT * FROM tb_produtos WHERE pro_codigo = ?";

		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				p.setCodigo(rs.getInt("pro_codigo"));
				p.setDescricao(rs.getString("pro_descricao"));
				p.setValor(rs.getDouble("pro_valor"));
				p.setQuantidade(rs.getInt("pro_quantidade"));
				p.setFornecedor((Fornecedor) rs.getObject("tb_fornecedores_for_codigo"));
				p.setCategoria((Categoria) rs.getObject("tb_categoria_cat_codigo"));

			}
			return p;
		} catch (SQLException ex) {
			System.out.println("Erro: " + ex);
			return null;
		} finally {
			BancoConnection.closeConnection(con);
		}
	}

	public void mostrarProduto() {
		String sql = "SELECT * FROM tb_produtos";
	
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			ResultSet rs = stm.executeQuery();
			System.out.println("\nTODOS OS PRODUTOS\n");

			while (rs.next()) {

				System.out.println("CODIGO PRODUTO: " + rs.getInt("pro_codigo"));
				System.out.println("DESCRICAO PRODUTO: " + rs.getString("pro_descricao"));
				System.out.println("CODIGO FORNECEDOR: " + rs.getInt("tb_fornecedores_for_codigo"));
				System.out.println("\n");
				
			}
			rs.close();

		} catch (SQLException ex) {
			System.out.println("Erro: " + ex);
		} finally {
			BancoConnection.closeConnection(con);
		}

	}
}
