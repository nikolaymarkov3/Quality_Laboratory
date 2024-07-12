package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Logger;

public class BaseStep {
	
	@Step("Клик по элементу {webElement}")
	public <T> T clickElement(WebElement webElement, T step) {
		webElement.click();
		Logger.logInfo("Клик по кнопке " + webElement.getText());
		return step;
	}
	
	public<A, E, T> BaseStep assertEquals(A actual, E expected, T message) {
		Assert.assertEquals(actual, expected, message.toString());
		return this;
	}
	
	@Step("Ввести {text}  в поле {webElement}")
	public <T> T inputValue(WebElement webElement, String text, T step) {
		webElement.sendKeys(text);
		Logger.logInfo("Ввести " + text + " в поле " + webElement.getText());
		return step;
	}
}
