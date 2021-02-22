package pages;

import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public WebElement searchField() {
		return findElement("//header/div[1]/div[1]/div[5]/form[1]/div[1]/div[1]/span[1]/input[1]");
	}

	public WebElement searchButton() {
		return findElement("//header/div[1]/div[1]/div[5]/form[1]/div[1]/div[1]/span[2]/button[1]");
	}

	public WebElement logInButton() {
		return findElement("//span[contains(text(),'Log in')]");
	}

	public WebElement allowAllCookiesButton() {
		return findElement("//body[1]/div[10]/div[1]/div[2]/div[1]/div[2]/a[1]");
	}
	
	public WebElement makeupNavElem() {
		return findElement("//body[1]/div[4]/nav[1]/div[2]/ul[1]/li[4]/a[1]/span[1]");
	}
	
	public WebElement productElem() {
		return findElement("//body/main[@id='main-content']/div[1]/div[3]/form[1]/div[6]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]");
	}
	
	public WebElement quantityButton() {
		return findElement("//body/div[8]/div[5]/div[1]/div[4]/div[3]/div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/select[1]");
	}
	public WebElement addToCartButton() {
		return findElement("//em[contains(text(),'Add to cart')]");
	}
	public WebElement shoppingBagButton() {
		return findElement("//header/div[1]/div[1]/div[4]/div[1]/a[1]/span[1]"); 
	}
	
	public WebElement emptyShoppingBagButton() {
		return findElement("//header/div[1]/div[1]/div[4]/div[1]/a[1]/i[1]"); 
	}
	public WebElement removeFromShoppingBagButton() {
		return findElement("//button[contains(text(),'X')]"); 
	}  
	
	public WebElement addToWishlistButton() {
		return findElement("//span[contains(text(),'Add to wishlist')]");
	}
	public WebElement shoppingBagButton2() {
		return findElement("//body/main[@id='main-content']/div[1]/div[3]/form[1]/div[6]/div[1]/div[2]/div[1]/a[1]/i[1]");
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

