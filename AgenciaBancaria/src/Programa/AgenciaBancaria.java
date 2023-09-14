package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
//	Scanner para leitura de dados
	static Scanner input = new Scanner(System.in);
	// Lista de contas com ArrayList (Vetor)
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {
		System.out.println("------------------------------------------------------");
		System.out.println("------------------Bem vindos a Agência----------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|   Opção 1 - Criar Conta   |");
		System.out.println("|   Opção 2 - Depositar     |");
		System.out.println("|   Opção 3 - Sacar         |");
		System.out.println("|   Opção 4 - Transferir    |");
		System.out.println("|   Opção 5 - Listar        |");
		System.out.println("|   Opção 6 - Sair          |");

		int operacao = input.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Obrigado por utilizar nossos serviços");
			System.exit(operacao);

		default:
			System.out.println("Opção inválida!");
			operacoes();
			break;
		}

	}

	public static void criarConta() {

		System.out.println("\nNome: ");
		String nome = input.next();

		System.out.println("\nCPF: ");
		String cpf = input.next();

		System.out.println("\nEmail: ");
		String email = input.next();

		Pessoa pessoa = new Pessoa(nome, cpf, email);

		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);

		System.out.println("Conta criada com sucesso!");

		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					conta = c;
				}

			}
		}
		return conta;

	}

	public static void depositar() {
		System.out.println("Digite o número da conta para fazer o depósito: ");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual o valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			System.out.println("Valor depositado com sucesso!");

		} else {
			System.out.println("Conta não encontada!");
		}
		operacoes();
	}

	public static void sacar() {
		System.out.println("Digite o número da conta para realizar o saque: ");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual o valor que deseja sacar? ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
		} else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
	}

	public static void transferir() {
		System.out.println("Digite o número da conta remetente: ");
		int numeroContaRemetente = input.nextInt();

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			System.out.println("Digite o númmero da conta do destinatário: ");
			int numeroContaDestinario = input.nextInt();

			Conta contaDestinatario = encontrarConta(numeroContaDestinario);

			if (contaDestinatario != null) {
				System.out.println("Digite o valor que deseja transferir: ");
				Double valor = input.nextDouble();

				contaRemetente.transferir(contaDestinatario, valor);
			} else {
				System.out.println("A conta para depósito não foi encontrada");
			}
		} else {
			System.out.println("Conta para transferência não encontrada");
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não há contas cadastradas!");
		}
		operacoes();
	}

}
