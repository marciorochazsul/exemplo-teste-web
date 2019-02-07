package object;

import static selenium.WebDriverProvider.getWebDriver;

import org.junit.After;
import org.junit.AfterClass;


public class FuncionalTest {

	
	
   
	    @After
	    public void cleanUp() {
	    	getWebDriver().close();
	    }

	
}
