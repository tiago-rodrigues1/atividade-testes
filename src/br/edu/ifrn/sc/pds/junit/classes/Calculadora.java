package br.edu.ifrn.sc.pds.junit.classes;

public class Calculadora {
	public static int somar (int n1, int n2) {
		return n1 + n2;
	}
	
	public static int subtrair (int n1, int n2) {
		return n1 - n2;
	}
	
	public static int multiplicar (int n1, int n2) {
		return n1 * n2;
	}
	
	public static double dividir (int n1, int n2) {
		if (n2 == 0) {
			throw new IllegalArgumentException("O divisor não pode ser igual a 0");
		}
		
		return n1 / n2;
	}
}
