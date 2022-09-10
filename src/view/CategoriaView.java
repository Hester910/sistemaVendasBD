package view;

import java.util.Scanner;

import dao.CategoriaDAO;
import model.Categoria;

public class CategoriaView {
	static Scanner sc = new Scanner(System.in);

	public void addCategoria() {
		System.out.println("CODIGO");

		int codigo = sc.nextInt();
		System.out.println("Nome");
		String nome = sc.next();
		Categoria c = new Categoria(codigo, nome);
		CategoriaDAO cDAO = new CategoriaDAO();
		cDAO.inserirCategoria(c);
	}

	public void listarCategoria() {
		CategoriaDAO cdao = new CategoriaDAO();
		System.out.println("\t\n---------CATEGORIAS--------\n");
		for (Categoria c : cdao.mostrarCategorias()) {
			System.out.println("CODIGO: " + c.getCodigo());
			System.out.println("NOME: " + c.getNome() + "\n");

		}
	}

	public void excluirCategoria() {
		CategoriaDAO cDao = new CategoriaDAO();
		System.out.println("\nDigite o codigo da categoria que voce deseja exlcuir");
		int codigo = sc.nextInt();

		cDao.deleteCategoria(codigo);
	}

	public void alterarCategoria() {
		CategoriaDAO cdao = new CategoriaDAO();
		System.out.println("\nDigite o numero da categoria que voce deseja alterar");
		int codigo = sc.nextInt();

		Categoria c = cdao.achar_categoria(codigo);
		System.out.println("\nAlterando informações da categoria");
		System.out.println("CODIGO " + c.getCodigo());
		System.out.println("NOME " + c.getNome() + "\n");

		System.out.println("--------DIGITE AS NOVAS INFORMAÇÕES--------");

		System.out.println("NOME");
		String nome = sc.next();

		cdao.alterarCategoria(c.getCodigo(), nome);
	}

}
