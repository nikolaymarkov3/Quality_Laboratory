package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AuthorizationStep extends BaseStep{
	
	@Step("Ввести {text}  в поле {webElement}")
	public <T>T inputUserName(WebElement webElement,WebDriver driver, String text,T step) {
		driver.switchTo().frame(2);
		Actions actions = new Actions(driver);
		actions.click(webElement)
				.sendKeys(text)
				.build()
				.perform();
		
		return step;
	}
}
