package model;

public class Item {

	private int codigo;
	private int quantidade;
	private double valorParcial;
	private Produto produto;

	public Item(int codigo, int quantidade, double valorParcial, Produto produto) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valorParcial = valorParcial;
		this.produto = produto;
	}

	public Item() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(double valorParcial) {
		this.valorParcial = valorParcial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Item [codigo=" + codigo + ", quantidade=" + quantidade + ", valorParcial=" + valorParcial + ", produto="
				+ produto + "]";
	}

}
