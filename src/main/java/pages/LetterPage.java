package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LetterPage extends BasePage{
	public LetterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@data-type='to']/descendant::input")
	private WebElement inputToWhom;
	
	@FindBy(xpath="//*[@contenteditable='true']//div")
	private WebElement inputLetter;
	
	@FindBy(xpath="//*[@data-test-id='send']")
	private WebElement buttonSend;
	
	@FindBy(xpath="//*[@data-test-id='send']")
	private WebElement sendingMessage;
	
	//href="/sent/3tTI59YZ/?"
}
