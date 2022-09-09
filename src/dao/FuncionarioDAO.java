package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Funcionario;


public class FuncionarioDAO {
	private Connection con = null;

	public FuncionarioDAO() {
		con = BancoConnection.getConnection();
	}

	public void inserirFuncionario(Funcionario fun) {
		String sql = "INSERT INTO tb_funcionarios (fun_codigo, fun_nome, fun_cpf, fun_senha) VALUES (?, ?, ?, ?)";
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			stm.setInt(1, fun.getCodigo());
			stm.setString(2, fun.getNome());
			stm.setString(3, fun.getCpf());
			stm.setString(4, fun.getSenha());
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
			
			while(rs.next()) {
				f.setCodigo(rs.getInt("fun_codigo"));
				f.setNome(rs.getString("fun_nome"));
				f.setCpf(rs.getString("fun_cpf"));
				f.setSenha(rs.getString("fun_senha"));
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
