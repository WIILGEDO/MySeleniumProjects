package test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import browser.Browser;

public class HomePageTest extends BaseTest {
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	Actions actions = new Actions(driver);

	// header elements test

	@Test
	public void tvProgramTest() throws InterruptedException {

		sportklub.homePage().tvProgramButton().click();

		sportklub.tvProgramPage().channel2().click();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//body[1]/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/ul[1]/li[1]/span[2]")));
		assertEquals("Danas", result.getText());
	}

	@Test
	public void languageSelectionTest() throws InterruptedException {

		WebElement countrySelectButton = sportklub.homePage().countrySelectButton();
		actions.moveToElement(countrySelectButton).perform();

		WebElement croatLanguage = sportklub.homePage().croatLanguage();

		wait.until(ExpectedConditions.elementToBeClickable(croatLanguage));
		croatLanguage.click();
		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")));
		assertEquals("Hrvatska", result.getText());
	}

	// @Test
	public void searchFieldTest() throws InterruptedException {

		WebElement searchButton = sportklub.homePage().searchButton();
		searchButton.click();
		WebElement searchField = sportklub.homePage().searchField();
		searchField.sendKeys("fudbal");
		searchField.sendKeys(Keys.ENTER);

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//body/main[@id='main-content']/div[1]/div[3]/form[1]/div[2]/div[2]/div[2]/div[4]/div[1]/span[1]")));
		assertNotEquals("0", result.getText());
	}

	// navigation bar tests

	@Test
	public void navBarTest() throws InterruptedException {

		WebElement footballNavElem = sportklub.homePage().footballNavElem();
		actions.moveToElement(footballNavElem).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/ul[1]/li[1]/ul[1]/li[1]/a[1]")));

		WebElement basketballNavElem = sportklub.homePage().basketballNavElem();
		actions.moveToElement(basketballNavElem).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/ul[1]/li[1]/ul[1]/li[1]/a[1]")));

		WebElement tenisNavElem = sportklub.homePage().tenisNavElem();
		actions.moveToElement(tenisNavElem).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/ul[1]/li[1]/ul[1]/li[3]/a[1]")));

		WebElement automotoNavElem = sportklub.homePage().automotoNavElem();
		actions.moveToElement(automotoNavElem).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[6]/ul[1]/li[1]/ul[1]/li[1]/a[1]")));

		WebElement volleyballNavElem = sportklub.homePage().volleyballNavElem();
		actions.moveToElement(volleyballNavElem).perform();

		sportklub.homePage().latestnewsNavElem().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Najnovije vesti')]")));
		assertEquals("NAJNOVIJE VESTI", result.getText());

	}

	@Test
	public void videoNavElemTest() throws InterruptedException {

		sportklub.homePage().videoNavElem().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'VIDEO - Najnovije')]")));
		assertEquals("VIDEO - NAJNOVIJE", result.getText());
	}

	@Test
	public void blogNavElemTest() throws InterruptedException {

		sportklub.homePage().blogNavElem().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Sve Vesti - BLOG')]")));
		assertEquals("SVE VESTI - BLOG", result.getText());
	}

	// footer links tests

	@Test
	public void marketingLinkTest() throws InterruptedException {

		sportklub.homePage().marketingLink().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Marketing')]")));
		assertEquals("Marketing", result.getText());
	}

	@Test
	public void contactLinkTest() throws InterruptedException {

		sportklub.homePage().marketingLink().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Kontakt')]")));
		assertEquals("Kontakt", result.getText());
	}

	@Test
	public void termsOfUseLinkLinkTest() throws InterruptedException {

		sportklub.homePage().termsOfUseLink().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Uslovi korišæenja')]")));
		assertEquals("Uslovi korišæenja", result.getText());
	}
}
