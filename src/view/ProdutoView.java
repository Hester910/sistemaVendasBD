package view;

import java.util.Scanner;

import dao.CategoriaDAO;
import dao.FornecedorDAO;
import dao.ProdutoDAO;
import model.Categoria;
import model.Fornecedor;
import model.Produto;

public class ProdutoView {
	public void addProduto() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("COD FORNECEDOR");
		int codigoFornecedor = sc.nextInt();

		System.out.println("COD CATEGORIA");
		int codigoCategoria = sc.nextInt();

		System.out.println("CODIGO");
		int codigoProduto = sc.nextInt();

		System.out.println("DESCRICAO");
		String descricao = sc.next();

		System.out.println("VALOR");
		double valor = sc.nextDouble();

		System.out.println("QUANTIDADE");
		int quantidade = sc.nextInt();
		


		FornecedorDAO fDAO = new FornecedorDAO();
		Fornecedor f = fDAO.achar_fornecedor(codigoFornecedor);

		CategoriaDAO cDAO = new CategoriaDAO();
		Categoria c = cDAO.achar_categoria(codigoCategoria);

		Produto p = new Produto(codigoProduto, descricao, valor, quantidade, f, c);
		System.out.println("\nRESUMO PRODUTO\n");
		System.out.println("FORNECEDOR " + p.getFornecedor().getCodigo());
		System.out.println("CATEGORIA " + p.getCategoria().getCodigo());
		System.out.println("COD_PRODUTO " + p.getCodigo());
		System.out.println("DESCRICAO " + p.getDescricao());
		System.out.println("VALOR " + p.getValor());
		System.out.println("QUANTIDADE " + p.getQuantidade());
		System.out.println("DESEJA FINALIZAR A VENDA?");
		int escolha = sc.nextInt();
		if(escolha == 1) {
			ProdutoDAO pDAO = new ProdutoDAO();
			pDAO.inserirProduto(p);
			
		}
	}

}
