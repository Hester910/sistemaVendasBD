package view;

import java.util.Scanner;

import dao.CategoriaDAO;
import model.Categoria;

public class CategoriaView {
	public void addCategoria() {
		Scanner sc = new Scanner(System.in);
		System.out.println("CODIGO");
		
		int codigo = sc.nextInt();
		System.out.println("Nome");
		String nome = sc.next();
		Categoria c = new Categoria(codigo, nome);
		CategoriaDAO cDAO = new CategoriaDAO();
		cDAO.inserirCategoria(c);
	}

}
