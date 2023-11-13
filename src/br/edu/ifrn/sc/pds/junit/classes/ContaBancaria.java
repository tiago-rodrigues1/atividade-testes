package br.edu.ifrn.sc.pds.junit.classes;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContaBancaria {
	private String cpfTitular;
	private double saldo;
	
	public ContaBancaria(String cpfTitular, double saldo) {
		
		if (saldo < 0) {
			throw new IllegalArgumentException("Não é possível criar uma conta com saldo negativo");
		} else if (!isCPFValid(cpfTitular)) {
			throw new IllegalArgumentException("Não é possível criar uma conta com CPF inválido");
		}
		
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
	}
	
	public double consultarSaldo() {
		return this.getSaldo();
	}
	
	public void depositar(double valorDeposito) {
		if (valorDeposito <= 0) {
			throw new IllegalArgumentException("O valor a ser depositado não pode ser menor ou igual a 0");
		}
		
		double novoSaldo = this.getSaldo() + valorDeposito;
		this.setSaldo(novoSaldo);
	}
	
	public void sacar(double valorSaque) {
		if (valorSaque <= 0) {
			throw new IllegalArgumentException("O valor a ser sacado não pode ser menor ou igual a 0");
		} else if (valorSaque > this.getSaldo()) {
			throw new IllegalArgumentException("Não é possível sacar um valor maior que o saldo");
		}
		
		double novoSaldo = this.getSaldo() - valorSaque;
		this.setSaldo(novoSaldo);
	}
	
	public void transferir(ContaBancaria destino, double valorTranferencia) {
		if (valorTranferencia > this.getSaldo()) {
			throw new IllegalArgumentException("Não é possível transferir um valor superior ao saldo");
		} else if (valorTranferencia <= 0) {
			throw new IllegalArgumentException("Não é possível transferir um valor menor ou igual a 0");
		} else if (this.equals(destino)) {
			throw new IllegalArgumentException("Não é possível transferir para a própria conta");
		}
		
		destino.depositar(valorTranferencia);
		double novoSaldo = this.getSaldo() - valorTranferencia;
		
		this.setSaldo(novoSaldo);
	}

	private String getCpfTitular() {
		return cpfTitular;
	}
	
	private void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	
	private double getSaldo() {
		return saldo;
	}
	
	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	private boolean isCPFValid(String cpf) {
		Pattern padrao = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$");
        Matcher matcher = padrao.matcher(cpf);
		
		return matcher.matches();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfTitular);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		return Objects.equals(cpfTitular, other.cpfTitular);
	}
	
}
