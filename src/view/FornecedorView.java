package view;

import java.util.Scanner;

import dao.FornecedorDAO;
import model.Fornecedor;


public class FornecedorView {
	
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

}
