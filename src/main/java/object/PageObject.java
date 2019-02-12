package object;

import static selenium.WebDriverProvider.getWebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	
	public PageObject() {
		super();
		PageFactory.initElements(getWebDriver(), this);
	}

	public static final WebDriverWait wait = new WebDriverWait(getWebDriver(), 300);
	
	public static void site(){
		
		getWebDriver().get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
	}
	
	protected void digitar(WebElement webElement, String text) {
		webElement.clear();
		wait.until(ExpectedConditions.visibilityOf(webElement)).sendKeys(text);

	}
	
	protected void clicar(WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement)).click();

	}
}
