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
import org.openqa.selenium.Keys;

import browser.Browser;

public class HomePageSmokeTest extends BaseTest {
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	
	@Test
	public void searchUsingLowerCaseOnlyTest() throws InterruptedException {
		
		WebElement searchButton = sportklub.homePage().searchButton();
		searchButton.click();
		WebElement searchField = sportklub.homePage().searchField();
		searchField.sendKeys("fudbal");
		searchField.sendKeys(Keys.ENTER);

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//body/main[@id='main-content']/div[1]/div[3]/form[1]/div[2]/div[2]/div[2]/div[4]/div[1]/span[1]")));
		assertNotEquals("0", result.getText());
	}
	
	//@Test 
	public void languageSelectionTest() throws InterruptedException {
		
		sportklub.homePage().countrySelectButton().click();
		Thread.sleep(3000);
		sportklub.homePage().croatLanguage().click();
		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")));
				  assertEquals("Hrvatska", result.getText());
	}
	

	//@Test
	public void tvProgramTest() throws InterruptedException {

		sportklub.homePage().tvProgramButton().click();
		
		WebElement result = wait
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/ul[1]/li[1]/span[2]")));
		  assertEquals("Danas", result.getText());
		  
		 sportklub.tvProgramPage().channel2().click();
		  
		  WebElement result2 = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[2]/div[2]/div[1]/main[1]/div[1]/div[1]/ul[1]/li[1]/span[2]")));
					  assertEquals("Danas", result2.getText());
	}	
	
}
	
	
	
	