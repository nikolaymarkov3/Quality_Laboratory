package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Logger;

public class AuthorizationStep extends BaseStep{
	
	@Step("Ввести {text}  в поле {webElementInput}")
	public <T>T inputUserName(WebElement webElementInput, WebElement button, WebDriver driver, String text,T step) {
		driver.switchTo().frame(2);
		Actions actions = new Actions(driver);
		actions.sendKeys(webElementInput,text)
				.click(button)
				.build()
				.perform();
		Logger.logInfo("Выбор вложенного окна, ввод текста= " + text + ", клик по кнопке= " + button.getText());
		
		return step;
	}
}
