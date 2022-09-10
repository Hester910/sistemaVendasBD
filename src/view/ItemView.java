package view;

import java.util.Scanner;

import dao.ItemDAO;
import dao.ProdutoDAO;
import model.Item;
import model.Produto;

public class ItemView {
	static Scanner sc = new Scanner(System.in);

	public void addItem() {
		Scanner sc = new Scanner(System.in);

		System.out.println("COD PRODUTO");
		int codigoProduto = sc.nextInt();

		System.out.println("CODIGO ITEM");
		int codigoItem = sc.nextInt();

		System.out.println("QUANTIDADE");
		int quantidade = sc.nextInt();

		System.out.println("VALOR PARCIAL");
		double valorParcial = sc.nextDouble();

		ProdutoDAO pDAO = new ProdutoDAO();
		Produto p = pDAO.achar_produto(codigoProduto);

		Item i = new Item(codigoItem, quantidade, valorParcial, p);

		System.out.println("\nRESUMO ITEM\n");
		System.out.println("COD PRODUTO: " + i.getProduto().getCodigo());
		System.out.println("COD ITEM:  " + i.getCodigo());
		System.out.println("QUANTIDADE " + i.getQuantidade());
		System.out.println("VALOR PARCIAL:  " + i.getValorParcial());
		System.out.println("DESEJA FINALIZAR?");
		int escolha = sc.nextInt();
		if (escolha == 1) {
			ItemDAO iDAO = new ItemDAO();
			iDAO.inserirItem(i);

		}

	}
	
	public void listarItem() {
		ItemDAO idao = new ItemDAO();
		idao.mostrarItens();
	}	
	
	
}