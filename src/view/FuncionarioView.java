package view;

import java.util.Scanner;

import dao.FuncionarioDAO;
import model.Funcionario;



public class FuncionarioView {
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

}
