package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	WebDriverWait wait = new WebDriverWait(driver, 30);

	@Before
	public void openLoginWindow() {
		
		alexandarCosmetics.homePage().logInButton().click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]")));

	}

	@Test
	public void logInUsingInvalidCredentialsTest() throws InterruptedException {

		alexandarCosmetics.logInPage().usernameField().sendKeys("marijanagol@gmail.com");

		alexandarCosmetics.logInPage().passwordField().sendKeys("M1234567");

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Username not found')]")));
		assertEquals("Username not found", result.getText());

	}

	@Test
	public void logInUsingInvalidPasswordTest() throws InterruptedException {
		
		alexandarCosmetics.logInPage().usernameField().sendKeys("marijanagolubovic7@gmail.com");

		alexandarCosmetics.logInPage().passwordField().sendKeys("M1234567");

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Invalid password')]")));
		assertEquals("Invalid password", result.getText());
	}

	@Test
	public void logInUsingInvalidEmailTest() throws InterruptedException {
		
		alexandarCosmetics.logInPage().usernameField().sendKeys("marijanagol@gmail.com");

		alexandarCosmetics.logInPage().passwordField().sendKeys("M12345g");

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Username not found')]")));
		assertEquals("Username not found", result.getText());
	}

	@Test 
	public void emptyUsernAndPassFieldTest() throws InterruptedException {

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Log in')]")));
		assertEquals("Log in", result.getText());
	}

	@Test
	public void forgotenPasswordLinkTest() throws InterruptedException {

		alexandarCosmetics.logInPage().forgotenPasswordLink().click();

		WebElement result = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Forgoten password')]")));
		assertEquals("FORGOTEN PASSWORD", result.getText());
	}

	@Test
	public void registerLinkTest() throws InterruptedException {

		alexandarCosmetics.logInPage().registerLink().click();

		WebElement result = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='register-submit']")));
		assertEquals("REGISTER", result.getText());
	}

	@Test
	public void usingValidCredentialsLogInTest() throws InterruptedException {
		
		alexandarCosmetics.logInPage().usernameField().sendKeys("marijanagolubovic7@gmail.com");

		alexandarCosmetics.logInPage().passwordField().sendKeys("M12345g");

		alexandarCosmetics.logInPage().submitButton().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Marijana Goluboviæ')]")));
		assertEquals("Marijana Goluboviæ", result.getText());
	}
}
