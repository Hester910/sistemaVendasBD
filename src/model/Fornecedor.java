package model;

public class Fornecedor {
	private int codigo;
	private String descricao;

	public Fornecedor(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Fornecedor( String descricao) {
		this.descricao = descricao;
	}

	public Fornecedor() {

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

	@Override
	public String toString() {
		return "Fornecedor [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}
