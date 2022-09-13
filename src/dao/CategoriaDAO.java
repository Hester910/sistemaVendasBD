package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;

public class CategoriaDAO {

	private Connection con = null;
	
	public CategoriaDAO() {
		con = BancoConnection.getConnection();
	}
	
	public void inserirCategoria(Categoria c) {
		String sql = "INSERT INTO tb_categoria (cat_nome) VALUES ( ?)";
		try {
			con = BancoConnection.getConnection();
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			//stm.setInt(1, c.getCodigo());
			stm.setString(1, c.getNome());
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
	
	public ArrayList<Categoria> mostrarCategorias(){
		ArrayList<Categoria> retorno = new ArrayList<>();
		String sql = "SELECT * FROM tb_categoria";
		
		try {
			con = BancoConnection.getConnection();
			
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Categoria c = new Categoria();
				
				c.setCodigo(rs.getInt("cat_codigo"));
				c.setNome(rs.getString("cat_nome"));
				
				retorno.add(c);
			}
			rs.close();
			
			return retorno;

		}catch (SQLException ex) {
			System.out.println("Erro: " + ex);
			return null;
		}finally {
			BancoConnection.closeConnection(con);
		}
		
	}
	
	public void deleteCategoria(int codigo) {
		String sql = "DELETE FROM tb_categoria WHERE cat_codigo = ?";
		String sql2 = "DELETE FROM tb_produtos WHERE pro_codigo tb_categoria_cat_codigo";
		
		try {
			con = BancoConnection.getConnection();
			
			PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setInt(1, codigo);
			stm2.executeUpdate();
			
			
			//Excluindo
			
			PreparedStatement stm1 = con.prepareStatement(sql);
			stm1.setInt(1, codigo);
			stm1.executeUpdate();
			System.out.println("\nCategoria Deletada do banco de dados");
		}catch (SQLException ex) {
			System.out.println("Erro: " + ex);
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
	public void alterarCategoria(int codigo, String nome) {
		String sql = "UPDATE tb_categoria SET cat_codigo = ?, cat_nome = ?";
		
		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			stm.setString(2, nome);
			stm.executeUpdate();
			System.out.println("\nCategoria Alterada\n");
		}catch (SQLException e) {
			System.out.println("Erro : " + e);
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
}
