package test;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShoppingCartTest extends BaseTest {
	WebDriver driver = Browser.getBrowser();
	WebDriverWait wait = new WebDriverWait(driver, 50);
	Actions actions = new Actions(driver);

	@Test
	public void addOneItemTest() throws InterruptedException {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[10]/div[1]/div[2]/div[1]")));

		alexandarCosmetics.homePage().allowAllCookiesButton().click();

		alexandarCosmetics.homePage().makeupNavElem().click();
		alexandarCosmetics.homePage().productElem().click();
		alexandarCosmetics.homePage().addToCartButton().click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//header/div[1]/div[1]/div[4]/div[1]/a[1]/span[1]")));

		WebElement shoppingBag = alexandarCosmetics.homePage().shoppingBagButton();
		actions.moveToElement(shoppingBag).perform();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[4]/div[1]/div[1]/h3[1]")));
		assertEquals("1 product in cart", result.getText());
	}

	@Test
	public void testQuantityIncrease() throws InterruptedException {

		alexandarCosmetics.homePage().makeupNavElem().click();
		alexandarCosmetics.homePage().productElem().click();
		alexandarCosmetics.homePage().quantityButton().sendKeys(Keys.ARROW_DOWN);

		alexandarCosmetics.homePage().addToCartButton().click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//header/div[1]/div[1]/div[4]/div[1]/a[1]/span[1]")));

		WebElement shoppingBag = alexandarCosmetics.homePage().shoppingBagButton();
		actions.moveToElement(shoppingBag).perform();

		WebElement result = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[4]/div[1]/div[1]/h3[1]")));
		assertEquals("2 products in cart", result.getText());
	}

	@Test
	public void removeFromShoppingBagTest() throws InterruptedException {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//header/div[1]/div[1]/div[4]/div[1]/a[1]/span[1]")));

		alexandarCosmetics.homePage().shoppingBagButton().click();

		alexandarCosmetics.homePage().removeFromShoppingBagButton().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'My cart (0)')]")));
		assertEquals("My cart (0)", result.getText());
	}

	@Test
	public void addToWishlistTest() throws InterruptedException {

		alexandarCosmetics.homePage().makeupNavElem().click();
		alexandarCosmetics.homePage().productElem().click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//header/div[1]/div[1]/div[4]/div[1]/a[1]/span[1]")));

		alexandarCosmetics.homePage().shoppingBagButton().click();

		alexandarCosmetics.homePage().addToWishlistButton().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@id='swal2-title']")));
		assertEquals("You need to be logged-in in order to add product to the Wishlist", result.getText());
	}

	@Test
	public void shoppingBagButtonTest() throws InterruptedException {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//header/div[1]/div[1]/div[4]/div[1]/a[1]/i[1]")));

		alexandarCosmetics.homePage().emptyShoppingBagButton().click();

		WebElement result = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Your cart is empty')]")));
		assertEquals("Your cart is empty", result.getText());
	}

	@Test
	public void shoppingBagButton2Test() throws InterruptedException {

		alexandarCosmetics.homePage().makeupNavElem().click();
		alexandarCosmetics.homePage().shoppingBagButton2().click();

		WebElement result = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//em[contains(text(),'Add to cart')]")));
		assertEquals("ADD TO CART", result.getText());
	}
}
