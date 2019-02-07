package testes;


import static org.junit.Assert.assertTrue;
import static selenium.WebDriverProvider.getWebDriver;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import object.FuncionalTest;
import object.PageObject;
import pages.SimuladorPage;

public class SimuladorTest extends FuncionalTest{
	
	SimuladorPage page = PageFactory.initElements(getWebDriver(), SimuladorPage.class);
	
	public void setup(){
		
		page = new SimuladorPage();
	}
  
	@Test
    public void validarCliqueNoBotaoSimularComCamposVazios(){
       
		PageObject.site();
		page.clicaBotaoSimular();
		assertTrue(page.isMensagemPresente());
    }	

    
  
}
