package Programa;

public class Pessoa {

//	Construtor
	public Pessoa(String nome, String cpf, String email) {

		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		counter += 1;
	}

//	Contador de pessoas
	private static int counter = 1;

// Propiedades ou Atributos
	private String nome;
	private String cpf;
	private String email;

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
		cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "\nNome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nEmail: " + this.getEmail();
	}

}
