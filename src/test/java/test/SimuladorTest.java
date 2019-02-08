package test;


import static org.junit.Assert.assertTrue;
import static selenium.WebDriverProvider.getWebDriver;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import object.FuncionalTest;
import object.PageObject;
import pages.SimuladorPage;
import utils.Report;

public class SimuladorTest extends FuncionalTest{
	
	SimuladorPage page = PageFactory.initElements(getWebDriver(), SimuladorPage.class);
	
	public void setup(){
		
		page = new SimuladorPage();
	}
	

	@Rule
	public Report screenshotTestRule = new Report();
  
	@Test
    public void validarCliqueNoBotaoSimularComCamposVazios(){
       
		PageObject.site();
		page.clicaBotaoSimular();
		assertTrue(page.isMensagemPresente());
    }	
	
	@Test
    public void validarValorMinimoNoCampoAplicar(){
       
		PageObject.site();
		page.preencherCampoAplicar(String.valueOf(15));
		page.clicarTeclaTab();
		assertTrue(page.isMensagemPresente());
    }	
	
	@Test
    public void validarValorMaximoNoCampoAplicar(){
       
		PageObject.site();
		page.preencherCampoAplicar(String.valueOf(999999999));
		page.clicarTeclaTab();
		assertTrue(page.isMensagemPresente());
    }	
	
	
	@Test
    public void validarSeValorRendimentoEExibido() throws InterruptedException{
       
		PageObject.site();
		page.preencherCampoAplicar(String.valueOf(2000));
		page.preencherCampoInvestir(String.valueOf(2000));
		page.preencherCampoTempoInvestimento(String.valueOf(1));
		page.clicaBotaoSimular();
		assertTrue(page.isResultadoSimulacao());
    }	
	
	

    
  
}
