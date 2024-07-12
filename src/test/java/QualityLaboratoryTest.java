import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.LetterPage;
import pages.MailPage;
import pages.MainPage;
import steps.AuthorizationStep;
import steps.LetterStep;
import steps.MailStep;
import steps.MainStep;

import static utils.Letter.MESSAGE;

public class QualityLaboratoryTest extends BaseTest {

	MainStep mainStep = new MainStep();
	AuthorizationStep authorizationStep = new AuthorizationStep();
	MailStep mailStep = new MailStep();
	LetterStep letterStep = new LetterStep();
	
	MainPage mainPage;
	AuthorizationPage authorizationPage;
	MailPage mailPage;
	LetterPage letterPage;
	
	@BeforeClass
	void createPage() {
		mainPage = new MainPage(driver);
		authorizationPage = new AuthorizationPage(driver);
		mailPage = new MailPage(driver);
		letterPage = new LetterPage(driver);
	}
	
	@Test
	public void testSendEmail() throws InterruptedException {
	
		mainStep.clickElement(mainPage.getLoginButton(), authorizationStep)
				.inputUserName(authorizationPage.getInputUserName(),driver, "Ввести никнейм",authorizationStep)
				.clickElement(authorizationPage.getNextButton(), authorizationStep)
				.inputValue(authorizationPage.getInputPassword(), "Ввести пароль",authorizationStep)
				.clickElement(authorizationPage.getSubmitButton(), mailStep)
				.clickElement(mailPage.getWriteLetterButton(),letterStep)
				.inputValue(letterPage.getInputToWhom(), "Ввести адрес получателя", letterStep)
				.inputValue(letterPage.getInputLetter(),MESSAGE.value, letterStep)
				.clickElement(letterPage.getButtonSend(),letterStep)
				.assertEquals(letterPage.getSendingMessage().getText(), "Письмо отправлено", "Письмо не отправлено");
	}
}
