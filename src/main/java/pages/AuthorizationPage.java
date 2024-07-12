package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AuthorizationPage extends BasePage{
	public AuthorizationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement inputUserName;
	
	@FindBy(xpath="//*[@id='login-content']")
	private WebElement form;
	
	@FindBy(xpath="//*[@data-test-id='next-button']")
	private WebElement nextButton;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement inputPassword;
	
	@FindBy(xpath="//*[@data-test-id='submit-button']")
	private WebElement submitButton;
}
