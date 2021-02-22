package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;

public class RegistrationTest extends BaseTest2 {
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Actions actions = new Actions(driver);

	@Before
	public void openRegistrationPage() {

		sportklub.skForumPage().registrationButton().click();
		WebElement monthInput = sportklub.registrationPage().monthInput();

		monthInput.click();
		monthInput.sendKeys(Keys.ARROW_DOWN);

		WebElement dayInput = sportklub.registrationPage().dayInput();

		dayInput.click();
		dayInput.sendKeys(Keys.ARROW_DOWN);

		WebElement yearInput = sportklub.registrationPage().yearInput();

		yearInput.sendKeys("1998");
		sportklub.registrationPage().proceedButton().click();

	}

	@Test
	public void invalidUsernameTest() throws InterruptedException {

		sportklub.registrationPage().usernameField().sendKeys("Us");
		sportklub.registrationPage().passwordField().sendKeys("M12345g");
		sportklub.registrationPage().passwordConfirmField().sendKeys("M12345g");
		sportklub.registrationPage().emailField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().emailConfirmField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().termsagreeBox().click();
		sportklub.registrationPage().submitButton().click();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//li[contains(text(),'Your username cannot be shorter than 3 characters.')]")));
		assertEquals("Your username cannot be shorter than 3 characters.", result.getText());
	}

	@Test
	public void emptyUsernameFieldTest() throws InterruptedException {

		sportklub.registrationPage().usernameField().sendKeys("");
		sportklub.registrationPage().passwordField().sendKeys("M12345g");
		sportklub.registrationPage().passwordConfirmField().sendKeys("M12345g");
		sportklub.registrationPage().emailField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().emailConfirmField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().termsagreeBox().click();
		sportklub.registrationPage().submitButton().click();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//li[contains(text(),'You have left a required field blank.')]")));
		assertEquals("You have left a required field blank.", result.getText());

		WebElement result2 = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//li[contains(text(),'Please complete the required field \"Username\".')]")));
		assertEquals("Please complete the required field \"Username\".", result2.getText());
	}

	@Test
	public void notMatchingPasswTest() throws InterruptedException {

		sportklub.registrationPage().usernameField().sendKeys("User");
		sportklub.registrationPage().passwordField().sendKeys("M12345g");
		sportklub.registrationPage().passwordConfirmField().sendKeys("M12345");
		sportklub.registrationPage().emailField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().emailConfirmField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().termsagreeBox().click();
		sportklub.registrationPage().submitButton().click();

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		assertEquals("The entered passwords do not match.", alertMessage);
		driver.switchTo().alert().accept();
	}

	@Test
	public void emptyPasswordFieldsTest() throws InterruptedException {

		sportklub.registrationPage().usernameField().sendKeys("User");
		sportklub.registrationPage().passwordField().sendKeys("");
		sportklub.registrationPage().passwordConfirmField().sendKeys("");
		sportklub.registrationPage().emailField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().emailConfirmField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().termsagreeBox().click();
		sportklub.registrationPage().submitButton().click();

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		assertEquals("Please fill out both password fields.", alertMessage);
		driver.switchTo().alert().accept();
	}

	@Test
	public void emptyEmailFieldsTest() throws InterruptedException {

		sportklub.registrationPage().usernameField().sendKeys("User");
		sportklub.registrationPage().passwordField().sendKeys("M12345g");
		sportklub.registrationPage().passwordConfirmField().sendKeys("M12345g");
		sportklub.registrationPage().emailField().sendKeys("");
		sportklub.registrationPage().emailConfirmField().sendKeys("");
		sportklub.registrationPage().termsagreeBox().click();
		sportklub.registrationPage().submitButton().click();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//li[contains(text(),'Please complete the required field \"Email\".')]")));
		assertEquals("Please complete the required field \"Email\".", result.getText());
	}

	@Test
	public void invalidEmailFieldsTest() throws InterruptedException {

		sportklub.registrationPage().usernameField().sendKeys("User");
		sportklub.registrationPage().passwordField().sendKeys("M12345g");
		sportklub.registrationPage().passwordConfirmField().sendKeys("M12345g");
		sportklub.registrationPage().emailField().sendKeys("emailtest1gmail.com");
		sportklub.registrationPage().emailConfirmField().sendKeys("emailtest1gmail.com");
		sportklub.registrationPage().termsagreeBox().click();
		sportklub.registrationPage().submitButton().click();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//li[contains(text(),'You entered an invalid email address.')]")));
		assertEquals("You entered an invalid email address.", result.getText());
	}

	// @Test
	public void notAcceptingTermsTest() throws InterruptedException {

		sportklub.registrationPage().usernameField().sendKeys("User");
		sportklub.registrationPage().passwordField().sendKeys("M12345g");
		sportklub.registrationPage().passwordConfirmField().sendKeys("M12345g");
		sportklub.registrationPage().emailField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().emailConfirmField().sendKeys("emailtest1@gmail.com");

		sportklub.registrationPage().submitButton().click();
		// h2[contains(text(),'vBulletin Message')]
		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[2]/div[2]/div[1]/div[1]")));
		assertEquals("You have chosen not to accept the forum rules, so registration cannot continue.\r\n" + "\r\n"
				+ "Click here to return to the main forums page, or click the 'Back' button on your browser if you now want to agree with the forum rules.",
				result.getText());
	}

	@Test
	public void notEnteringCaptchaTest() throws InterruptedException {

		sportklub.registrationPage().usernameField().sendKeys("User");
		sportklub.registrationPage().passwordField().sendKeys("M12345g");
		sportklub.registrationPage().passwordConfirmField().sendKeys("M12345g");
		sportklub.registrationPage().emailField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().emailConfirmField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().termsagreeBox().click();
		sportklub.registrationPage().submitButton().click();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//li[contains(text(),'The string you entered for the image verification ')]")));
		assertEquals("The string you entered for the image verification did not match what was displayed.",
				result.getText());
	}

	@Test
	public void resetButtonTest() throws InterruptedException {

		sportklub.registrationPage().usernameField().sendKeys("User");
		sportklub.registrationPage().passwordField().sendKeys("M12345g");
		sportklub.registrationPage().passwordConfirmField().sendKeys("M12345g");
		sportklub.registrationPage().emailField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().emailConfirmField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().termsagreeBox().click();
		sportklub.registrationPage().resetFieldsButton().click();
		Thread.sleep(3000);
		sportklub.registrationPage().termsagreeBox().click();
		Thread.sleep(3000);
	}

	// @Test
	public void validDataRegisterTest() throws InterruptedException {

		int rand = 1 + (int) (Math.random() * 1000);
		sportklub.registrationPage().usernameField().sendKeys("User" + rand);
		sportklub.registrationPage().passwordField().sendKeys("M12345g");
		sportklub.registrationPage().passwordConfirmField().sendKeys("M12345g");
		sportklub.registrationPage().emailField().sendKeys("emailtest1@gmail.com");
		sportklub.registrationPage().emailConfirmField().sendKeys("emailtest1@gmail.com");
		Thread.sleep(30000);
		sportklub.registrationPage().termsagreeBox().click();
		sportklub.registrationPage().submitButton().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[2]/div[2]/div[1]/div[1]")));
		assertEquals(
				"Thank you for registering, Mar.Gol. An email has been dispatched to marijanagolubovic7@gmail.com with details on how to activate your account. Click here to return to where you were previously.\r\n"
						+ "\r\n"
						+ "You will receive an email in your inbox. You MUST follow the link in that email before you can post on these forums. Until you do that, you will be told that you do not have permission to post.",
				result.getText());
	}

}
