package br.com.k21;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	@Test
	public void testeComissaoValorVenda100Retorna5Reais() {
		double venda = 100;
		double saida = 0;
		int saidaEsperada = 5;
		saida = Calculadora.calculaComissao(venda);
		assertEquals(saidaEsperada,saida,0);
	}
	
	@Test
	public void testeComissaoValorVenda10000Retorna500Reais() {
		double venda = 10000;
		double saida = 0;
		int saidaEsperada = 500;
		saida = Calculadora.calculaComissao(venda);
		assertEquals(saidaEsperada,saida,0);
	}
	
	@Test
	public void testeComissaoValorVenda1Retorna5Centavos() {
		double venda = 1;
		double saida = 0;
		double saidaEsperada = 0.05;
		saida = Calculadora.calculaComissao(venda);
		assertEquals(saidaEsperada,saida,0);
	}
	
	@Test
	public void testeComissaoValorVenda99CentavosRetorna() {
		double venda = 0.99;
		double saida = 0;
		double saidaEsperada = 0.04;
		saida = Calculadora.calculaComissao(venda);
		assertEquals(saidaEsperada,saida,0);
	}
	
}
