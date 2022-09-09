package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Fornecedor;

public class FornecedorDAO {
	private Connection con = null;

	public FornecedorDAO() {
		con = BancoConnection.getConnection();
	}

	public void inserirFornecedor(Fornecedor f) {
		String sql = "INSERT INTO tb_fornecedores (for_codigo, for_descricao) VALUES (?, ?)";
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			stm.setInt(1, f.getCodigo());
			stm.setString(2, f.getDescricao());
			stm.execute();
			System.out.println("Fornecedor cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		} finally {
			BancoConnection.closeConnection(con);
		}
	}
	
	public Fornecedor achar_fornecedor(int codigo) {
		Fornecedor f = new  Fornecedor();
		String sql = "SELECT * FROM tb_fornecedores WHERE for_codigo = ?";
		
		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				f.setCodigo(rs.getInt("for_codigo"));
				f.setDescricao(rs.getString("for_descricao"));
			}
			return f;
		}catch (SQLException ex) {
			System.out.println("Erro: " + ex);
			return null;
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
}
