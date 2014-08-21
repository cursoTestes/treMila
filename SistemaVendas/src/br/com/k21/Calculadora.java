package br.com.k21;

public class Calculadora {

	public double calculaComissao(double valorVenda) {
				
		double d = valorVenda * 0.05;
		
		d = d * 100;
		d = Math.floor(d);
		d = d/100;
		
		return d;
	}
	
	

}
