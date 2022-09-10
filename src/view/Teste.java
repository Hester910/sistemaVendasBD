package view;

import java.util.Scanner;

public class Teste {
	CategoriaView c = new CategoriaView();
	FornecedorView f = new FornecedorView();
	FuncionarioView fun = new FuncionarioView();
	ItemView i = new ItemView();
	ProdutoView p = new ProdutoView();
	VendaView v = new VendaView();

	public void menu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1) Cadastrar Categoria");
		System.out.println("2) Listar Categorias");
		System.out.println("3) Excluir Categoria");
		System.out.println("4) Alterar Categoria");
		System.out.println("--------------------------");
		System.out.println("5) Cadastrar Fornecedor");
		System.out.println("6) Listar Fornecedores");
		System.out.println("7) Excluir Fornecedor");
		System.out.println("8) Alterar Fornecedor");
		System.out.println("-------------------------");
		System.out.println("9) Cadastrar Funcionario");
		System.out.println("10) Listar Funcionario");
		System.out.println("11) Excluir Funcionario");
		System.out.println("12) Alterar Funcionario");
		System.out.println("-------------------------");
		System.out.println("13) Cadastrar Itens");
		System.out.println("14) Listar Itens");
		System.out.println("-------------------------");
		System.out.println("15) Cadastrar Produtos");
		System.out.println("16) Listar Produtos");
		System.out.println("-------------------------");
		System.out.println("17) Cadastrar Vendas");
		System.out.println("18) Listar Venda");
		System.out.println("-------------------------");
		System.out.println("99) Sair");
		int op = sc.nextInt();
		switch (op) {
		case 1: {
			c.addCategoria();
			menu();
			break;
		}
		case 2: {
			c.listarCategoria();
			menu();
			break;
		}
		case 3: {
			c.excluirCategoria();
			menu();
			break;
		}
		case 4: {
			c.alterarCategoria();
			menu();
			break;
		}
		case 5: {
			f.addFornecedor();
			menu();
			break;
		}
		case 6: {
			f.listarFornecedores();
			menu();
			break;
		}
		case 7: {
			f.excluirFornecedor();
			menu();
			break;
		}
		case 8: {
			f.alterarFornecedor();
			menu();
			break;
		}
		case 9: {
			fun.addFuncionario();
			menu();
			break;
		}
		case 10:{
			fun.listarFuncionario();
			menu();
			break;
		}
		case 11: {
			fun.excluirFuncionario();
			menu();
			break;
		}
		case 12: {
			fun.alterarFuncionario();
			menu();
			break;
		}
		case 13: {
			i.addItem();
			menu();
			break;
		}
		
		case 14: {
			i.listarItem();
			menu();
			break;
		}
		case 15: {
			p.addProduto();
			menu();
			break;
		}
		case 16: {
			p.listarProdutos();
			menu();
			break;
		}		
		case 17: {
			v.addVenda();
			menu();
			break;
		}
		case 18: {
			v.listarVendas();
			menu();
			break;
		}		
		case 99:{
			System.exit(0);
		}
		default:
			System.out.println("Opção invalida");
			menu();
		}

	}

	public static void main(String[] args) {
		// CategoriaView c = new CategoriaView();
		// c.addCategoria();

		// FornecedorView f = new FornecedorView();
		// f.addFornecedor();

		// FuncionarioView func = new FuncionarioView();
		// func.addFuncionario();

		// ProdutoView p = new ProdutoView();
		// p.addProduto();

		// ItemView i = new ItemView();
		// i.addItem();

		// VendaView v = new VendaView();
		// v.addVenda();

		Teste t = new Teste();
		t.menu();

	}

}
