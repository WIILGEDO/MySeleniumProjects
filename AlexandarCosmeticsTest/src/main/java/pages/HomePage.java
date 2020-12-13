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
}


