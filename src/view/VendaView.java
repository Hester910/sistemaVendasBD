package view;

import java.util.Scanner;

import dao.FuncionarioDAO;
import dao.ItemDAO;
import dao.VendaDAO;
import model.Funcionario;
import model.Item;
import model.Venda;


public class VendaView {
	public void addVenda() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("COD FUNCIONARIO");
		int codigoFuncionario = sc.nextInt();
		
		System.out.println("COD ITEM");
		int codigoItem = sc.nextInt();
		
		System.out.println("CODIGO VENDA");
		int codigoVenda = sc.nextInt();

		//System.out.println("HORARIO");
		String horario;
			

		System.out.println("VALOR TOTAL");
		double valorTotal = sc.nextDouble();

		System.out.println("CPF CLIENTE");
		String cpfCliente = sc.next();

		System.out.println("DESCONTO");
		double desconto = sc.nextDouble();

		FuncionarioDAO fDAO = new FuncionarioDAO();
		Funcionario f = fDAO.achar_funcionario(codigoFuncionario);
		
		ItemDAO iDAO = new ItemDAO();
		Item i = iDAO.achar_item(codigoItem);
		
		Venda venda = new Venda(codigoVenda, valorTotal, cpfCliente, desconto, f, i);
		System.out.println("\nRESUMO VENDA\n");
		System.out.println("FUNCIONARIO: " + venda.getFuncionario().getCodigo());
		System.out.println("CODIGO VENDA: " + venda.getCodigo());
		System.out.println("HORARIO: " + venda.getHorario());
		System.out.println("VALOR_TOTAL: " + venda.getValorTotal());
		System.out.println("CPF_CLIENTE: " + venda.getClienteCpf());
		System.out.println("DESCONTO: " + venda.getDesconto());
		
		System.out.println("DESEJA FINALIZAR A VENDA?");
		int escolha = sc.nextInt();
		if(escolha == 1) {
			VendaDAO vDAO = new VendaDAO();
			vDAO.inserirVenda(venda);;
			
		}
		
	}
}