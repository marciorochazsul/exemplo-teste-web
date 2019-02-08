package pages;

import static selenium.WebDriverProvider.getWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

import object.PageObject;

public class SimuladorPage extends PageObject {

	@FindBy(id = "valorAplicar")
	private WebElement campoValorAplicar;

	@FindBy(id = "valorInvestir")
	private WebElement campoValorInvestir;

	@FindBy(xpath = "//*[@id='tempo']")
	private WebElement campoValorTempoInvestimento;

	@FindBy(xpath = "//*[@id='formInvestimento']/div[5]/ul/li[2]/button")
	private WebElement botaoSimular;

	public void preencherCampoAplicar(String text) {

		digitar(campoValorAplicar, text);
	}

	public void preencherCampoInvestir(String text) {

		digitar(campoValorInvestir, text);
	}

	public void preencherCampoTempoInvestimento(String text) {

		digitar(campoValorTempoInvestimento, text);
	}

	public void clicaBotaoSimular() {

		clicar(botaoSimular);
	}

	public boolean isMensagemPresente() {

		return getWebDriver().findElement(By.id("valorAplicar-error")).isDisplayed();
	}

	public boolean isResultadoSimulacao() {

		return getWebDriver().findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]")).isDisplayed();
	}

	public void clicarTeclaTab() {
		WebElement element = campoValorAplicar;
		element.sendKeys(Keys.TAB);

	}

}
