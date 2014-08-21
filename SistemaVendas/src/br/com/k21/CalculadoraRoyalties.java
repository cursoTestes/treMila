package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaDAO;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaDAO vendaDAO = new VendaDAO();
	private Calculadora calc = new Calculadora();

	public double calcular(int mes, int ano) {
		double soma = 0;
		double unitaria = 0;
		
		List<Venda> vendas = vendaDAO.obterVendasPorMesEAno(ano, mes) ;
				
		for (Venda venda : vendas) {
			double valorVenda = venda.getValor();
			unitaria = valorVenda - calc.calculaComissao(valorVenda);
			soma = soma + unitaria;			
		} 		
		
		return soma * 0.2;
	}

	public VendaDAO getVendaDAO() {
		return vendaDAO;
	}

	public void setVendaDAO(VendaDAO vendaDAO) {
		this.vendaDAO = vendaDAO;
	}

	public Calculadora getCalc() {
		return calc;
	}

	public void setCalc(Calculadora calc) {
		this.calc = calc;
	}

}
