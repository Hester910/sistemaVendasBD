package model;

public class Venda {

	private int codigo;
	private String horario;
	private double valorTotal;
	private String clienteCpf;
	private double desconto;
	private Funcionario funcionario;
	private Item item;

	public Venda(int codigo, String horario, double valorTotal, String clienteCpf, double desconto,
			Funcionario funcionario, Item item) {

		this.codigo = codigo;
		//this.horario = java.time.LocalDateTime.now().toString();
		this.horario = horario;
		this.valorTotal = valorTotal;
		this.clienteCpf = clienteCpf;
		this.desconto = desconto;
		this.funcionario = funcionario;
		this.item = item;
	}

	
	public Venda(String horario, double valorTotal, String clienteCpf, double desconto, Funcionario funcionario,
			Item item) {
		super();
		this.horario = horario;
		this.valorTotal = valorTotal;
		this.clienteCpf = clienteCpf;
		this.desconto = desconto;
		this.funcionario = funcionario;
		this.item = item;
	}


	public Venda() {

	}

	public Venda(int codigo, double valorTotal, String clienteCpf, double desconto, Funcionario funcionario,
			Item item) {
		this.codigo = codigo;
		this.valorTotal = valorTotal;
		this.clienteCpf = clienteCpf;
		this.desconto = desconto;
		this.funcionario = funcionario;
		this.item = item;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getClienteCpf() {
		return clienteCpf;
	}

	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", horario=" + horario + ", valorTotal=" + valorTotal + ", clienteCpf="
				+ clienteCpf + ", desconto=" + desconto + ", funcionario=" + funcionario + ", item=" + item + "]";
	}

}
