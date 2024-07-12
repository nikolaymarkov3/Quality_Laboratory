package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MailPage extends BasePage{
	public MailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@href='/compose/']")
	private WebElement writeLetterButton;
	
	
	
	//type="text"
	
}
