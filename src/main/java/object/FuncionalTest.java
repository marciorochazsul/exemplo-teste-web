package object;

import static selenium.WebDriverProvider.getWebDriver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public class FuncionalTest {

		@BeforeClass
		public static void login(){
			PageObject.site();
			
		}
	
	
	 	@AfterClass
	    public static void tearDownClass() {
	        getWebDriver().close();
	    }
	    
	    @After
	    public void cleanUp() {
	        getWebDriver().manage().deleteAllCookies();
	        getWebDriver().navigate().refresh();
	    }

	
}
