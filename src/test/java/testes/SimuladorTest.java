package testes;


import static selenium.WebDriverProvider.getWebDriver;

import org.junit.After;
import org.junit.Test;
import object.FuncionalTest;




public class SimuladorTest extends FuncionalTest{
	
	
  
	@Test
    public void simuladorTest(){
       
		getWebDriver().get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
		//Thread.sleep(2000);
    }	

    
  
}
