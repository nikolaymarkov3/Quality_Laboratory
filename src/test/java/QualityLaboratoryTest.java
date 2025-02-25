import base.BaseTest;
import io.qameta.allure.*;
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
	@Owner("Николай Марков")
	@TmsLink("1")
	@Story("US-1.0")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Авторизация и отправка письма")
	public void testSendEmail() {
	
		mainStep.clickElement(mainPage.getLoginButton(), authorizationStep)
				.inputUserName(authorizationPage.getInputUserName(),authorizationPage.getNextButton(), driver, "Ввести никнейм",authorizationStep)
//				.clickElement(authorizationPage.getNextButton(), authorizationStep)
				.inputValue(authorizationPage.getInputPassword(), "Ввести пароль",authorizationStep)
				.clickElement(authorizationPage.getSubmitButton(), mailStep)
				.clickElement(mailPage.getWriteLetterButton(),letterStep)
				.inputValue(letterPage.getInputToWhom(), "Ввести адрес получателя", letterStep)
				.inputValue(letterPage.getInputLetter(),MESSAGE.value, letterStep)
				.clickElement(letterPage.getButtonSend(),letterStep)
				.assertEquals(letterPage.getSendingMessage().getText(), "Письмо отправлено", "Письмо не отправлено");
	}

//	public void testSendEmail() {
//		methodA();
//	}
//
//	void methodE() {System.out.println("E");}
//
//	void methodD() throws ArithmeticException {
//		System.out.println("D");
//		int a = 1/0;
//	}
//	void methodC() {System.out.println("C");}
//	void methodB()
//	{System.out.println("B");
//		methodC();
//		methodD();
//		methodE();
//	}
//	void methodA() {
//		try {
//			System.out.println("A");
//
//			methodB();
//			methodC();
//		}catch (Exception e){
////           throw e;
//			System.out.println(e);
//		}
//	}
}
