package br.edu.ifrn.sc.pds.junit.classes;

public class Banco {
	private double montante;
	private double jurosMensal;
	private int quantidadeParcelas;
	private double valorParcela;
	
	public Banco(double montante, double jurosMensal) {
		this.setMontante(montante);
		this.jsetJurosMensal(jurosMensal);
		
		
		this.setQuantidadeParcelas(this.montante);
		this.setValorParcela();
	}
	
	private void setQuantidadeParcelas(double montante) {
		if (montante >= 3000 && montante <= 8000) {
			this.quantidadeParcelas = 12;
		} else if (montante > 8000 && montante <= 25000) {
			this.quantidadeParcelas = 36;
		} else if (montante > 25000 && montante <= 50000) {
			this.quantidadeParcelas = 60;
		} else if (montante > 50000 && montante <= 150000) {
			this.quantidadeParcelas = 120;
		}
	}
	
	public int getQuantidadeParcelas() {
		return this.quantidadeParcelas;
	}
	
	private void setValorParcela() {
		double valorSemJuros = this.montante / this.quantidadeParcelas;
		double valorComJuros = valorSemJuros + (valorSemJuros * jurosMensal);
		
		this.valorParcela = valorComJuros;
	}
	
	public double getValorParcela() {
		return this.valorParcela;
	}
	
	public double getMontante() {
		return montante;
	}
	
	public void setMontante(double montante) {
		if (montante <= 0) {
			throw new IllegalArgumentException("Não é possível criar a classe Banco com montante menor ou igual a 0");
		} else if (montante < 3000 && montante > 150000) {
			throw new IllegalArgumentException("Não é possível criar a classe Banco com montante menor que 3000 e maior que 150000");
		}
		
		this.montante = montante;
	}
	
	public double getJurosMensal() {
		return jurosMensal;
	}
	
	public void jsetJurosMensal(double jurosMensal) {
		if (jurosMensal <= 0) {
			throw new IllegalArgumentException("Não é possível criar a classe Banco com jurosMensal menor ou igual a 0");
		}
		
		this.jurosMensal = jurosMensal;
	}
	
}
