package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainPage extends BasePage{
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='mailbox']//button")
	private WebElement loginButton;
}
