package pages;

import static selenium.WebDriverProvider.getWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

import object.PageObject;

public class SimuladorPage extends PageObject {

	@FindBy(id = "valorAplicar")
	private WebElement campoValorAplicar;

	@FindBy(xpath = "//*[@id='formInvestimento']/div[5]/ul/li[2]/button")
	private WebElement botaoSimular;

	public void preencherCampoAplicar(String text) {

		digitar(campoValorAplicar, text);
	}

	public void clicaBotaoSimular() {

		clicar(botaoSimular);
	}

	public boolean isMensagemPresente() {

		return getWebDriver().findElement(By.id("valorAplicar-error")).isDisplayed();
	}

}
