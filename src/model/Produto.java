package model;

public class Produto {
	private int codigo;
	private String descricao;
	private double valor;
	private int quantidade;
	private Fornecedor fornecedor;
	private Categoria categoria;

	public Produto(int codigo, String descricao, double valor, int quantidade, Fornecedor fornecedor,
			Categoria categoria) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
	}

	
	public Produto(String descricao, double valor, int quantidade, Fornecedor fornecedor, Categoria categoria) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
	}


	public Produto() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", valor=" + valor + ", quantidade="
				+ quantidade + ", fornecedor=" + fornecedor + ", categoria=" + categoria + "]";
	}

}
