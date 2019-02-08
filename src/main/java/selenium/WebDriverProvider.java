package selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class WebDriverProvider {

	private static final String OPERATING_SYSTEM = System.getProperty("os.name");
	private static final String WINDOWS_OS = "WINDOWS";
	private static final int DEFAULT_TIMEOUT_IN_SECONDS = 10;
	private static final boolean HEADLESS = false;

	private static WebDriver WEB_DRIVER;

	private WebDriverProvider() {
		super();
	}

	public static WebDriver getWebDriver() {
		if (isInitialized()) {
			initialize();
		}
		return WEB_DRIVER;
	}

	private static boolean isInitialized() {
		return WEB_DRIVER == null;
	}

	private static void initialize() {
		configurarGeckodriver();
		WEB_DRIVER = new FirefoxDriver(headless());
		WEB_DRIVER.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j.properties");
	}

	private static void configurarGeckodriver() {
		String geckodriver = isOperatingOverWindows() ? "geckodriver_v0.22.exe" : "geckodriver-v0.19.1";
		System.setProperty("webdriver.gecko.driver", "geckodriver/" + geckodriver);
	}

	private static boolean isOperatingOverWindows() {
		return OPERATING_SYSTEM.toUpperCase().indexOf(WINDOWS_OS) >= 0;
	}

	private static FirefoxOptions headless() {
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(HEADLESS);
		return options;
	}
	
	
}
