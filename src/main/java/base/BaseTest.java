package base;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;
import steps.BaseStep;

import java.net.MalformedURLException;

import static utils.WebDriverManager.getInst;

public class BaseTest {

	
	public WebDriver driver;
	public RemoteWebDriver driverR;

	@Getter
	private static final String BASE_URL = "https://mail.ru/";
	
	@Step("Открытие стартовой страницы {baseUrl}")
	private void openBaseUrl(WebDriver driver, String baseUrl) {
		driver.get(baseUrl);
	}
	
	@BeforeClass
	@Parameters("browser")
	public void load(@Optional("chrome") String browser) throws MalformedURLException {
		switch (browser) {
			case "firefox" -> {
				FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
////		options.addArguments("--window-size=500,500");
//		options.addArguments("--log-level=0");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
				driverR = (RemoteWebDriver) getInst().getDriver("firefox");
				driverR.manage().window().maximize();
				openBaseUrl(driverR, getBASE_URL());
			}
			
			case "chrome" -> {
				ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
////		options.addArguments("--window-size=500,500");
//		options.addArguments("--log-level=0");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
				driver = getInst().getDriver("chrome");
				driver.manage().window().maximize();
				openBaseUrl(driver, getBASE_URL());
			}
			
			case "edge" -> {
				EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless");
////		options.addArguments("--window-size=500,500");
//		options.addArguments("--log-level=0");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
				driver = getInst().getDriver("edge");
				driver.manage().window().maximize();
				openBaseUrl(driver, getBASE_URL());
			}
		}
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
