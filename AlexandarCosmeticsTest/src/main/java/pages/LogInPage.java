package pages;

import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage {

	public WebElement usernameField() {
		return findElement("//input[@id='username']");
	}

	public WebElement passwordField() {
		return findElement("//input[@id='password']");
	}

	public WebElement submitButton() {
		return findElementByCss("#_submit");
	}

	public WebElement forgotenPasswordLink() {
		return findElement("//a[contains(text(),'Forgoten password')]");
	}

	public WebElement registerLink() {
		return findElementByCss("#login-register-button");
	}
}
