package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private VendaDAO dao;
	private Calculadora calc;
	private CalculadoraRoyalties calculadoraRoyalties;

	@Before
	public void inicializar()
	{
		dao = Mockito.mock(VendaDAO.class);
		calc = Mockito.mock(Calculadora.class);
		calculadoraRoyalties = new CalculadoraRoyalties();
		calculadoraRoyalties.setVendaDAO(dao);
		calculadoraRoyalties.setCalc(calc);
		
	}
	
	@Test
	public void mesSemVenda() {
	
		int mes = 1;
		int ano = 1983;
		
		double valorEsperado = 0;
		
		Mockito.when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(new ArrayList()); 
		
		double retorno = calculadoraRoyalties.calcular(mes, ano);
		
		assertEquals(valorEsperado, retorno, 0);
	}	
	
	@Test
	public void mesComVenda() {
	
		int mes = 1;
		int ano = 1989;
		
		double valorEsperado = 19;
		Mockito.when(dao.obterVendasPorMesEAno(ano, mes)).thenReturn(Arrays.asList(new Venda(1, 1, mes, ano, 100))); 
		Mockito.when(calc.calculaComissao(100)).thenReturn(5.0);
		
		double retorno = calculadoraRoyalties.calcular(mes, ano);
		
		assertEquals(valorEsperado, retorno, 0);
	}
	
}
