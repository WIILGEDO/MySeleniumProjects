package test;

import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import browser.Browser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogInTest extends BaseTest {
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 50);

	@Test
	public void logInUsingInvalidCredentialsTest() throws InterruptedException {

		alexandarCosmetics.homePage().logInButton().click();

		alexandarCosmetics.logInPage().usernameField().sendKeys("marijanagol@gmail.com");

		alexandarCosmetics.logInPage().passwordField().sendKeys("M1234567");

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(text(),'Korisnik nije pronaðen')]")));
		assertEquals("Korisnik nije pronaðen", result.getText());

	}

	@Test
	public void logInUsingInvalidPasswordTest() throws InterruptedException {

		alexandarCosmetics.homePage().logInButton().click();

		alexandarCosmetics.logInPage().usernameField().sendKeys("marijanagolubovic7@gmail.com");

		alexandarCosmetics.logInPage().passwordField().sendKeys("M1234567");

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(text(),'Lozinka nije validna')]")));
		assertEquals("Lozinka nije validna", result.getText());
	}

	@Test
	public void logInUsingInvalidEmailTest() throws InterruptedException {

		alexandarCosmetics.homePage().logInButton().click();

		alexandarCosmetics.logInPage().usernameField().sendKeys("marijanagol@gmail.com");

		alexandarCosmetics.logInPage().passwordField().sendKeys("M12345g");

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(text(),'Korisnik nije pronaðen')]")));
		assertEquals("Korisnik nije pronaðen", result.getText());
	}

	@Test
	public void emptyUsernAndPassFieldTest() throws InterruptedException {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[10]/div[1]/div[2]/div[1]")));

		alexandarCosmetics.homePage().allowAllCookiesButton().click();

		alexandarCosmetics.homePage().logInButton().click();

		WebElement submitButton = alexandarCosmetics.logInPage().submitButton();

		wait.until(ExpectedConditions.elementToBeClickable(submitButton));

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Log in')]")));
		assertEquals("Log in", result.getText());
	}

	@Test
	public void forgotenPasswordLinkTest() throws InterruptedException {

		alexandarCosmetics.homePage().logInButton().click();

		alexandarCosmetics.logInPage().forgotenPasswordLink().click();

		WebElement result = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Forgoten password')]")));
		assertEquals("FORGOTEN PASSWORD", result.getText());
	}

	@Test
	public void registerLinkTest() throws InterruptedException {

		alexandarCosmetics.homePage().logInButton().click();

		alexandarCosmetics.logInPage().registerLink().click();

		WebElement result = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='register-submit']")));
		assertEquals("REGISTER", result.getText());
	}

	@Test
	public void validCredentialsLogInTest() throws InterruptedException {

		alexandarCosmetics.homePage().logInButton().click();

		WebElement usernameField = alexandarCosmetics.logInPage().usernameField();

		wait.until(ExpectedConditions.elementToBeClickable(usernameField));

		alexandarCosmetics.logInPage().usernameField().sendKeys("marijanagolubovic7@gmail.com");

		alexandarCosmetics.logInPage().passwordField().sendKeys("M12345g");

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Marijana Goluboviæ')]")));
		assertEquals("Marijana Goluboviæ", result.getText());
	}
}
