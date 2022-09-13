package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Fornecedor;

public class FornecedorDAO {
	private Connection con = null;

	public FornecedorDAO() {
		con = BancoConnection.getConnection();
	}

	public void inserirFornecedor(Fornecedor f) {
		String sql = "INSERT INTO tb_fornecedores (for_descricao) VALUES (?)";
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			//stm.setInt(1, f.getCodigo());
			stm.setString(1, f.getDescricao());
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
	
	public ArrayList<Fornecedor> mostrarFornecedor(){
		ArrayList<Fornecedor> retorno = new ArrayList<>();
		String sql = "SELECT * FROM tb_fornecedores";
		
		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Fornecedor f = new Fornecedor();
				
				f.setCodigo(rs.getInt("for_codigo"));
				f.setDescricao(rs.getString("for_descricao"));
				
				retorno.add(f);
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
	
	public void deleteFornecedor(int codigo) {
		String sql = "DELETE FROM tb_fornecedores WHERE for_codigo = ?";
		String sql2 = "DELETE FROM tb_produtos WHERE pro_codigo tb_fornecedores_for_codigo";
		
		try {
			con = BancoConnection.getConnection();
			
			PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setInt(1, codigo);
			stm2.executeUpdate();
			
			
			PreparedStatement stm1 = con.prepareStatement(sql);
			stm1.setInt(1, codigo);
			stm1.executeUpdate();
			System.out.println("\nFornecedor deletado com sucesso");
		}catch (SQLException ex) {
			System.out.println("Erro: " + ex);
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	public void alterarFornecedor(int codigo, String descricao) {
		String sql = "UPDATE tb_fornecedores SET for_codigo = ?, for_descricao = ?";
		
		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			stm.setString(2, descricao);
			stm.executeUpdate();
			System.out.println("\nFornecedor Alterado\n");
		}catch (SQLException e) {
			System.out.println("Erro : " + e);
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
	
}
