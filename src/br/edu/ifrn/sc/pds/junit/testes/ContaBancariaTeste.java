package br.edu.ifrn.sc.pds.junit.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ifrn.sc.pds.junit.classes.ContaBancaria;

class ContaBancariaTeste {
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoCriarContaComSaldoNegativo() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", -200);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível criar uma conta com saldo negativo", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoCriarContaComCPFInvalido() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-aa", 200);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível criar uma conta com CPF inválido", e.getMessage());
		}
	}
	
	@Test
	public void deveriaConsultarSaldo() {
		ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
		
		assertEquals(100.35, cb.consultarSaldo());
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoDepositarValorNulo() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
			cb.depositar(0);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("O valor a ser depositado não pode ser menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoDepositarValorNegativo() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
			cb.depositar(-3);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("O valor a ser depositado não pode ser menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaAtualizarSaldoCorretamenteAoDepositar400() {
		ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
		cb.depositar(400);
		
		double resultadoEsperado = 400 + 100.35;
		
		assertEquals(resultadoEsperado, cb.consultarSaldo());
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoSacarValorNegativo() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
			cb.sacar(-40);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("O valor a ser sacado não pode ser menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoSacarValorNulo() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
			cb.sacar(0);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("O valor a ser sacado não pode ser menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoSacarValorSuperiorAoSaldo() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
			cb.sacar(200);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível sacar um valor maior que o saldo", e.getMessage());
		}
	}
	
	@Test
	public void deveriaAtualizarSaldoCorretamenteAoSacar87() {
		ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
		cb.sacar(87);
		
		double resultadoEsperado = 100.35 - 87;
		
		assertEquals(resultadoEsperado, cb.consultarSaldo());
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoTransferirValorNegativo() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
			ContaBancaria destino = new ContaBancaria("001.000.000-00", 400);
			
			cb.transferir(destino, -222);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível transferir um valor menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoTransferirValorNulo() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
			ContaBancaria destino = new ContaBancaria("001.000.000-00", 400);
			
			cb.transferir(destino, 0);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível transferir um valor menor ou igual a 0", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoTransferirValorSuperiorAoSaldo() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
			ContaBancaria destino = new ContaBancaria("001.000.000-00", 400);
			
			cb.transferir(destino, 323);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível transferir um valor superior ao saldo", e.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarMensagemDeErroCorretaAoTransferirParaPropriaConta() {
		try {
			ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
			ContaBancaria destino = new ContaBancaria("000.000.000-00", 400);
			
			cb.transferir(destino, 40);
			
			fail("Não lançou a Exception esperada");
		} catch (IllegalArgumentException e) {
			assertEquals("Não é possível transferir para a própria conta", e.getMessage());
		}
	}
	
	@Test
	public void deveriaDebitarrSaldoCorretamenteAoTransferir42() {
		ContaBancaria cb = new ContaBancaria("000.000.000-00", 100.35);
		ContaBancaria destino = new ContaBancaria("111.111.111-11", 400);
		
		cb.transferir(destino, 42);
		
		double resultadoEsperado = 100.35 - 42;
		
		assertEquals(resultadoEsperado, cb.consultarSaldo());
	}

}
