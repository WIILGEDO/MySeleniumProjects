package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;

public class SearchTest extends BaseTest {
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 30);

	@Before
	public void searchFieldClear() {
		alexandarCosmetics.homePage().searchField().clear();
	}

	@Test
	public void emptySearchFieldTest() throws InterruptedException {

		alexandarCosmetics.homePage().searchButton().click();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//body/main[@id='main-content']/div[1]/div[3]/form[1]/div[2]/div[2]/div[2]/div[4]/div[1]/span[1]")));
		assertNotEquals("0", result.getText());
	}

	@Test
	public void searchUsingLowerCaseOnlyTest() throws InterruptedException {

		alexandarCosmetics.homePage().searchField().sendKeys("lipstick");
		alexandarCosmetics.homePage().searchButton().click();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//body/main[@id='main-content']/div[1]/div[3]/form[1]/div[2]/div[2]/div[2]/div[4]/div[1]/span[1]")));
		assertNotEquals("0", result.getText());
	}

	@Test
	public void searchUsingUppAndLowCaseTest() throws InterruptedException {

		alexandarCosmetics.homePage().searchField().sendKeys("LipsticK");
		alexandarCosmetics.homePage().searchButton().click();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//body/main[@id='main-content']/div[1]/div[3]/form[1]/div[2]/div[2]/div[2]/div[4]/div[1]/span[1]")));
		assertNotEquals("0", result.getText());
	}

	@Test
	public void searchUsingNumbersTest() throws InterruptedException {

		WebElement allowCookiesButton = alexandarCosmetics.homePage().allowAllCookiesButton();
		wait.until(ExpectedConditions.elementToBeClickable(allowCookiesButton));

		alexandarCosmetics.homePage().allowAllCookiesButton().click();

		alexandarCosmetics.homePage().searchField().sendKeys("98765");

		alexandarCosmetics.homePage().searchButton().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='product-results']")));
		assertEquals("Unable to find product. Please change one of the specified conditions.", result.getText());
	}

	@Test
	public void searchUsingSpaceBeforeKeywordTest() throws InterruptedException {

		alexandarCosmetics.homePage().searchField().sendKeys("   lipstick");
		alexandarCosmetics.homePage().searchButton().click();

		WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//body/main[@id='main-content']/div[1]/div[3]/form[1]/div[2]/div[2]/div[2]/div[4]/div[1]/span[1]")));
		assertNotEquals("0", result.getText());
	}

	@Test
	public void searchUsingSpecCharTest() throws InterruptedException {

		alexandarCosmetics.homePage().searchField().sendKeys(".,&>");
		alexandarCosmetics.homePage().searchButton().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='product-results']")));
		assertEquals("Unable to find product. Please change one of the specified conditions.", result.getText());
	}
}
