package view;

import java.util.Scanner;

import dao.FornecedorDAO;
import dao.FornecedorDAO;
import model.Categoria;
import model.Fornecedor;


public class FornecedorView {
	static Scanner sc = new Scanner(System.in);

	
	public void addFornecedor() {
		Scanner sc = new Scanner (System.in);
		System.out.println("CODIGO");
		int codigo = sc.nextInt();
		System.out.println("DESCRICAO");
		String descricao = sc.next();
		Fornecedor f = new Fornecedor(codigo, descricao);
		FornecedorDAO fDAO = new FornecedorDAO();
		fDAO.inserirFornecedor(f);
	}
	
	public void listarFornecedores() {
		FornecedorDAO fdao = new FornecedorDAO();
		System.out.println("\t\n---------FORNECEDORES--------\n");
		for (Fornecedor f : fdao.mostrarFornecedor()) {
			System.out.println("CODIGO: " + f.getCodigo());
			System.out.println("DESCRICAO: " + f.getDescricao() + "\n");
			
		}
	}
	
	public void excluirFornecedor() {
		FornecedorDAO fdao = new FornecedorDAO();
		System.out.println("\nDigite o codigo do fornecedor que voce deseja exlcuir");
		int codigo = sc.nextInt();
		
		fdao.deleteFornecedor(codigo);
	}
	
	
	public void alterarFornecedor() {
		FornecedorDAO fdao = new FornecedorDAO();
		System.out.println("\nDigite o numero da fornecedor que voce deseja alterar");
		int codigo = sc.nextInt();
		
		Fornecedor f = fdao.achar_fornecedor(codigo);
		System.out.println("\nAlterando informações do fornecedor");
		System.out.println("CODIGO " + f.getCodigo());
		System.out.println("DESCRICAO " + f.getDescricao() + "\n");
		
		System.out.println("--------DIGITE AS NOVAS INFORMAÇÕES--------");
		
		
		System.out.println("DESCRICAO");
		String descricao = sc.next();
		
		
		fdao.alterarFornecedor(f.getCodigo(), descricao);
	}


}
