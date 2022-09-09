package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Categoria;

public class CategoriaDAO {

	private Connection con = null;
	
	public CategoriaDAO() {
		con = BancoConnection.getConnection();
	}
	
	public void inserirCategoria(Categoria c) {
		String sql = "INSERT INTO tb_categoria (cat_codigo, cat_nome) VALUES (?, ?)";
		try {
			con = BancoConnection.getConnection();
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, c.getCodigo());
			stm.setString(2, c.getNome());
			stm.execute();
			System.out.println("Categoria Adicionada com sucesso");
		}catch (SQLException e) {
			System.out.println("Erro: " + e);
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
	public Categoria achar_categoria(int codigo) {
		Categoria c = new  Categoria();
		String sql = "SELECT * FROM tb_categoria WHERE cat_codigo = ?";
		
		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				c.setCodigo(rs.getInt("cat_codigo"));
				c.setNome(rs.getString("cat_nome"));
			}
			return c;
		}catch (SQLException ex) {
			System.out.println("Erro: " + ex);
			return null;
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
}
