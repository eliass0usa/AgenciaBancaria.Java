package Programa;

import utilitarios.Utils;

public class Conta {

//	Construtor recebe apenas uma pessoa 
	public Conta(Pessoa pessoa) {

		this.numeroConta = contadorDeContas;
		this.pessoa = pessoa;
		contadorDeContas += 1;
	}

//	A cada conta criada, é atribuido um número
	private static int contadorDeContas = 1;

// 	Propiedades ou Atributos
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;

//	Getters and Setters	
	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

//	Método para retornar os atributos
	public String toString() {
		return "\nNúmero da conta: " + this.getNumeroConta() + "\nNome: " + this.pessoa.getNome() + "\nCpf: "
				+ this.pessoa.getCpf() + "\nEmail: " + this.pessoa.getEmail() + "\nSaldo: "
				+ Utils.doubleToString(this.getSaldo()) + "\n";

	}

//	Método de Depósito
	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o depósito.");
		}
	}

//	Método para Saque
	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o saque.");
		}

	}

//	Método para Transferência
	public void transferir(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);

			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferência realizada com sucesso!");
		} else {
			System.out.println("Não foi possível realizar a transferência");
		}
	}

}
