package base;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;
import steps.BaseStep;

import static utils.WebDriverManager.getInst;

public class BaseTest {
	BaseStep baseStep = new BaseStep();
	
	public WebDriver driver;
	@Getter
	private static final String BASE_URL = "https://mail.ru/";
	
	@Step("Открытие стартовой страницы {baseUrl}")
	private void openBaseUrl(WebDriver driver, String baseUrl) {
		driver.get(baseUrl);
	}
	
	@BeforeClass
	@Parameters("browser")
	public void load(@Optional("chrome") String browser){
		switch (browser) {
			case "firefox" -> {
				driver = getInst().getDriver("firefox");
				driver.manage().window().maximize();
				openBaseUrl(driver, getBASE_URL());
			}
			
			case "chrome" -> {
				driver = getInst().getDriver("chrome");
				driver.manage().window().maximize();
				openBaseUrl(driver, getBASE_URL());
			}
			
			case "edge" -> {
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
