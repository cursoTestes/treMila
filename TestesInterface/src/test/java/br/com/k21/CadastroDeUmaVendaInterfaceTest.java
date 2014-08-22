package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CadastroDeUmaVendaInterfaceTest extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		return new FirefoxDriver();
	}
	
	@Test
	public void teste_cadastra_uma_venda_Sem_preencher_campos_obrigatorios() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("");
		fill("#DataVenda").with("");
		fill("#Valor").with("");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O campo Id Vendedor � obrigat�rio.", findFirst("#validacaoVendedor").getText()); 
		Assert.assertEquals("O campo Valor � obrigat�rio.", findFirst("#validacaoValor").getText()); 
		Assert.assertEquals("O campo Data Venda � obrigat�rio.", findFirst("#validacaoDataVenda").getText());					
	}
	
	@Test
	public void teste_cadastra_uma_venda_com_sucesso() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("01");
		fill("#DataVenda").with("21/08/2014");
		fill("#Valor").with("1");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("Venda cadastrada com sucesso.", findFirst("#msg").getText()); 	
	}	
	
	@Test
	public void teste_cadastra_uma_venda_negativa() {
		goTo("http://localhost:58034/Venda/Add");
		fill("#Vendedor").with("01");
		fill("#DataVenda").with("21/08/2014");
		fill("#Valor").with("-1");
		
		submit("input[type=\"submit\"]");
		
		Assert.assertEquals("O valor da venda n�o pode ser negativo.", findFirst("#validacaoValor").getText()); 	
	}	

}
