package br.edu.ifrn.sc.pds.junit.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifrn.sc.pds.junit.classes.Banco;

class BancoTeste {

	@Test
	public void deveriaLancarMensagemDeErroCorretaAoCriarBancoComJurosNulo() {
		try {
			Banco b = new Banco(3000, 0);
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível criar a classe Banco com jurosMensal menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoCriarBancoComJurosNegativo() {
		try {
			Banco b = new Banco(3000, -1);
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível criar a classe Banco com jurosMensal menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoCriarBancoComMontanteNulo() {
		try {
			Banco b = new Banco(0, 1);
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível criar a classe Banco com montante menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoCriarBancoComMontanteNegativo() {
		try {
			Banco b = new Banco(-3000, 1);
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível criar a classe Banco com montante menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaRetornarValorDeParcelasCorretoParaMontante3000() {
		Banco b = new Banco(3000, 1);
		
		assertEquals(b.getQuantidadeParcelas(), 12);
	}
	
	@Test
	public void deveriaRetornarValorDeParcelasCorretoParaMontante20000() {
		Banco b = new Banco(20000, 1);
		
		assertEquals(b.getQuantidadeParcelas(), 36);
	}
	
	@Test
	public void deveriaRetornarValorDeParcelasCorretoParaMontante30000() {
		Banco b = new Banco(30000, 1);
		
		assertEquals(b.getQuantidadeParcelas(), 60);
	}
	
	@Test
	public void deveriaRetornarValorDeParcelasCorretoParaMontante60000() {
		Banco b = new Banco(60000, 1);
		
		assertEquals(b.getQuantidadeParcelas(), 120);
	}
	
	@Test
	public void deveriaRetornarValorDeParcelaComJuros() {
		Banco b = new Banco(60000, 0.1);
		
		double valorSemJuros = 60000 / 120;
		double valorComJurosEsperado = valorSemJuros * 0.1 + valorSemJuros;
		
		assertEquals(valorComJurosEsperado, b.getValorParcela());
	}

}
