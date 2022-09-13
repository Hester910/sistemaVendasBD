package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;
import model.Funcionario;

public class FuncionarioDAO {
	private Connection con = null;

	public FuncionarioDAO() {
		con = BancoConnection.getConnection();
	}

	public void inserirFuncionario(Funcionario fun) {
		String sql = "INSERT INTO tb_funcionarios ( fun_nome, fun_cpf, fun_senha) VALUES ( ?, ?, ?)";
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			//stm.setInt(1, fun.getCodigo());
			stm.setString(1, fun.getNome());
			stm.setString(2, fun.getCpf());
			stm.setString(3, fun.getSenha());
			stm.execute();
			System.out.println("Funcionario cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		} finally {
			BancoConnection.closeConnection(con);
		}
	}

	public Funcionario achar_funcionario(int codigo) {
		Funcionario f = new Funcionario();
		String sql = "SELECT * FROM tb_funcionarios WHERE fun_codigo = ?";
		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				f.setCodigo(rs.getInt("fun_codigo"));
				f.setNome(rs.getString("fun_nome"));
				f.setCpf(rs.getString("fun_cpf"));
				f.setSenha(rs.getString("fun_senha"));
			}
			return f;
		} catch (SQLException ex) {
			System.out.println("Erro: " + ex);
			return null;
		} finally {
			BancoConnection.closeConnection(con);
		}
	}

	public ArrayList<Funcionario> mostrarFuncionarios() {
		ArrayList<Funcionario> retorno = new ArrayList<>();
		String sql = "SELECT * FROM tb_funcionarios";

		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Funcionario f = new Funcionario();

				f.setCodigo(rs.getInt("fun_codigo"));
				f.setCpf(rs.getString("fun_cpf"));
				f.setNome(rs.getString("fun_nome"));
				f.setSenha(rs.getString("fun_senha"));

				retorno.add(f);
			}
			rs.close();

			return retorno;

		} catch (SQLException ex) {
			System.out.println("Erro: " + ex);
			return null;
		} finally {
			BancoConnection.closeConnection(con);
		}

	}
	
	
	public void deleteFuncionario(int codigo) {
		String sql = "DELETE FROM tb_funcionarios WHERE for_codigo = ?";
		String sql2 = "DELETE FROM tb_vendas WHERE ven_codigo tb_funcionarios_fun_codigo";
		
		try {
			con = BancoConnection.getConnection();
			
			PreparedStatement stm2 = con.prepareStatement(sql2);
			stm2.setInt(1, codigo);
			stm2.executeUpdate();
			
			
			//Excluindo
			
			PreparedStatement stm1 = con.prepareStatement(sql);
			stm1.setInt(1, codigo);
			stm1.executeUpdate();
			System.out.println("\nFuncionario Deletado do banco de dados");
		}catch (SQLException ex) {
			System.out.println("Erro: " + ex);
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
	public void alterarFuncionario(int codigo, String nome, String cpf, String senha) {
		String sql = "UPDATE tb_funcionarios SET fun_codigo = ?, fun_nome = ?, fun_cpf = ?, fun_senha = ?";
		
		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			stm.setString(2, nome);
			stm.setString(3, cpf);
			stm.setString(4, senha);
			stm.executeUpdate();
			System.out.println("\nFuncionario Alterado\n");
		}catch (SQLException e) {
			System.out.println("Erro : " + e);
		}finally {
			BancoConnection.closeConnection(con);
		}
	}
	
	

}
