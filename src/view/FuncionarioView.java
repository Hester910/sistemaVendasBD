package view;

import java.util.Scanner;

import dao.CategoriaDAO;
import dao.FuncionarioDAO;
import dao.FuncionarioDAO;
import model.Categoria;
import model.Funcionario;



public class FuncionarioView {
	static Scanner sc = new Scanner(System.in);

	public void addFuncionario() {
		Scanner sc = new Scanner (System.in);
		System.out.println("CODIGO");
		int codigo = sc.nextInt();
		System.out.println("NOME");
		String nome = sc.next();
		System.out.println("CPF");
		String cpf = sc.next();
		System.out.println("SENHA");
		String senha = sc.next();
		Funcionario fun = new Funcionario(codigo, nome, cpf, senha);
		FuncionarioDAO funDAO = new FuncionarioDAO();
		funDAO.inserirFuncionario(fun);
	}
	
	public void listarFuncionario() {
		FuncionarioDAO fdao = new FuncionarioDAO();
		System.out.println("\t\n---------FUNCIONARIOS--------\n");
		for (Funcionario f : fdao.mostrarFuncionarios()) {
			System.out.println("CODIGO: " + f.getCodigo());
			System.out.println("NOME: " + f.getNome());
			System.out.println("CPF: " + f.getCpf());
			System.out.println("SENHA: " + f.getSenha() + "\n");
			
		}
	}
	
	public void excluirFuncionario() {
		FuncionarioDAO fdao = new FuncionarioDAO();
		System.out.println("\nDigite o codigo do funcionario que voce deseja exlcuir");
		int codigo = sc.nextInt();
		
		fdao.deleteFuncionario(codigo);
	}
	
	public void alterarFuncionario() {
		FuncionarioDAO fDAO = new FuncionarioDAO();
		System.out.println("\nDigite o codigo do funcionario que voce deseja alterar");
		int codigo = sc.nextInt();
		
		Funcionario f = fDAO.achar_funcionario(codigo);
		System.out.println("\nAlterando informações do funcionario");
		System.out.println("CODIGO " + f.getCodigo());
		System.out.println("NOME " + f.getNome() + "\n");
		System.out.println("CPF " + f.getCpf() + "\n");
		System.out.println("SENHA " + f.getSenha() + "\n");
		
		
		System.out.println("--------DIGITE AS NOVAS INFORMAÇÕES--------");
		
		
		System.out.println("NOME");
		String nome = sc.next();
		System.out.println("CPF");
		String cpf = sc.next();
		System.out.println("SENHA");
		String senha = sc.next();
		
		
		fDAO.alterarFuncionario(f.getCodigo(), nome, cpf, senha);
	}


}
