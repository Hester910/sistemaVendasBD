package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import model.Funcionario;
import model.Item;
import model.Produto;
import model.Venda;


public class VendaDAO {
	private Connection con = null;

	public VendaDAO() {
		con = BancoConnection.getConnection();
	}

	public void inserirVenda(Venda v) {
		String sql = "INSERT INTO tb_vendas ( ven_horario, ven_valor_total, ven_cli_cpf, ven_desconto, tb_funcionarios_fun_codigo, tb_itens_ite_codigo) VALUES ( ?, ?, ?, ?, ?, ?)";
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			//stm.setInt(1, v.getCodigo());
			stm.setString(1, v.getHorario());
			stm.setDouble(2, v.getValorTotal());
			stm.setString(3, v.getClienteCpf());
			stm.setDouble(4, v.getDesconto());
			stm.setInt(5, v.getFuncionario().getCodigo());
			stm.setInt(6, v.getItem().getCodigo());
			
			stm.execute();
			System.out.println("Venda cadastrada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		} finally {
			BancoConnection.closeConnection(con);
		}
	}
	
	public Venda achar_venda(int codigo) {
		Venda v = new Venda();
		String sql = "SELECT * FROM tb_vendas WHERE ven_codigo = ?";

		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				v.setCodigo(rs.getInt("ven_codigo"));
				v.setHorario(rs.getString("ven_horario"));
				v.setValorTotal(rs.getDouble("ven_valor_total"));
				v.setClienteCpf(rs.getString("ven_cli_cpf"));
				v.setFuncionario((Funcionario)rs.getObject("tb_funcionarios_for_codigo"));
				v.setItem((Item)rs.getObject("tb_itens_ite_codigo"));

			}
			return v;
		} catch (SQLException ex) {
			System.out.println("Erro: " + ex);
			return null;
		} finally {
			BancoConnection.closeConnection(con);
		}
	}

	public void mostrarVendas() {
		String sql = "SELECT * FROM tb_vendas";

		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			System.out.println("\nTodas VENDAS\n");

			while (rs.next()) {
				System.out.println("CODIGO VENDA : " + rs.getInt("ven_codigo"));
				System.out.println("HORARIO: " + rs.getString("ven_horario"));
				System.out.println("VALOR TOTAL : " + rs.getDouble("ven_valor_total"));
				System.out.println("CPF CLIENTE : " + rs.getString("ven_cli_cpf"));
				System.out.println("DESCONTO: " + rs.getDouble("ven_desconto"));
				System.out.println("FUNCIONARIO: " + rs.getInt("tb_funcionarios_fun_codigo"));
				System.out.println("ITEM : " + rs.getInt("tb_itens_ite_codigo"));
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
