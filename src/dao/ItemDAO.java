package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Categoria;
import model.Item;
import model.Produto;

public class ItemDAO {
	private Connection con = null;

	public ItemDAO() {
		con = BancoConnection.getConnection();
	}

	public void inserirItem(Item i) {
		String sql = "INSERT INTO tb_itens (ite_codigo, ite_quantidade, ite_valor_parcial, tb_produtos_pro_codigo) VALUES (?, ?, ?, ?)";
		try {
			con = BancoConnection.getConnection();

			PreparedStatement stm = con.prepareStatement(sql);

			stm.setInt(1, i.getCodigo());
			stm.setInt(2, i.getQuantidade());
			stm.setDouble(3, i.getValorParcial());
			stm.setInt(4, i.getProduto().getCodigo());

			stm.execute();
			System.out.println("Item cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		} finally {
			BancoConnection.closeConnection(con);
		}
	}

	public Item achar_item(int codigo) {
		Item i = new Item();
		String sql = "SELECT * FROM tb_itens WHERE ite_codigo = ?";

		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, codigo);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				i.setCodigo(rs.getInt("ite_codigo"));
				i.setQuantidade(rs.getInt("ite_quantidade"));
				i.setValorParcial(rs.getDouble("ite_valor_parcial"));

			}
			return i;
		} catch (SQLException ex) {
			System.out.println("Erro: " + ex);
			return null;
		} finally {
			BancoConnection.closeConnection(con);
		}
	}

	public void mostrarItens() {
		String sql = "SELECT * FROM tb_itens";

		try {
			con = BancoConnection.getConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			System.out.println("\nTodos Itens\n");

			while (rs.next()) {
				System.out.println("CODIGO ITEM : " + rs.getInt("ite_codigo"));
				System.out.println("QUANTIDADE ITEM : " + rs.getInt("ite_quantidade"));
				System.out.println("VALOR PARCIAL ITEM : " + rs.getDouble("ite_valor_parcial"));
				System.out.println("PRODUTO ITEM : " + rs.getInt("tb_produtos_pro_codigo"));
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
