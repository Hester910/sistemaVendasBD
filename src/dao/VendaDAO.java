package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import model.Venda;


public class VendaDAO {
	private Connection con = null;

	public VendaDAO() {
		con = BancoConnection.getConnection();
	}

	public void inserirVenda(Venda v) {
		String sql = "INSERT INTO tb_vendas (ven_codigo, ven_horario, ven_valor_total, ven_cli_cpf, ven_desconto, tb_funcionarios_fun_codigo, tb_itens_ite_codigo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			stm.setInt(1, v.getCodigo());
			stm.setString(2, v.getHorario());
			stm.setDouble(3, v.getValorTotal());
			stm.setString(4, v.getClienteCpf());
			stm.setDouble(5, v.getDesconto());
			stm.setInt(6, v.getFuncionario().getCodigo());
			stm.setInt(7, v.getItem().getCodigo());
			
			stm.execute();
			System.out.println("Venda cadastrada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		} finally {
			BancoConnection.closeConnection(con);
		}
	}


}
