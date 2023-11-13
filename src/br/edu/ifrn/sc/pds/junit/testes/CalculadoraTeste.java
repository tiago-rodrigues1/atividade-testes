package br.edu.ifrn.sc.pds.junit.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifrn.sc.pds.junit.classes.Calculadora;

class CalculadoraTeste {

	@Test
	public void resultadoDaSomaDe3e5() {
		assertEquals(8, Calculadora.somar(3, 5));
	}

	@Test
	public void resultadoDaSubtracaoDe10e6() {
		assertEquals(4, Calculadora.subtrair(10, 6));
	}

	@Test
	public void resultadoDaMultiplicacaoDe6e7() {
		assertEquals(42, Calculadora.multiplicar(6, 7));
	}

	@Test
	public void resultadoDaDivisaoDe10e5() {
		assertEquals(2, Calculadora.dividir(10, 5));
	}

	@Test
	public void deveriaLancarIllegalArgumentExceptionComDivisor0() {
		try {
			Calculadora.dividir(2, 0);
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void deveriaLancarMensagemDeExcecaoCorretaComDivisor0() {
		try {
			Calculadora.dividir(2, 0);
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("O divisor não pode ser igual a 0", e.getMessage());
		}
	}

}
