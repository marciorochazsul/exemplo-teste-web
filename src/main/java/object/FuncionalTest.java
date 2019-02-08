package object;

import static selenium.WebDriverProvider.getWebDriver;

import org.junit.After;
import org.junit.AfterClass;


public class FuncionalTest {

	 	@AfterClass
	    public static void tearDownClass() {
	        getWebDriver().close();
	    }
	    
	    @After
	    public void cleanUp() {
	        getWebDriver().manage().deleteAllCookies();
	    }

	
}
