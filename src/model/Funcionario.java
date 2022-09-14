package model;

public class Funcionario {
	private int codigo;
	private String nome;
	private String cpf;
	private String senha;

	public Funcionario(int codigo, String nome, String cpf, String senha) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	public Funcionario( String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Funcionario() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + "]";
	}

}