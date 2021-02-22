package pages;

import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {
	
	public WebElement monthInput() {
		return findElement("//select[@id='month']");
	}

	public WebElement dayInput() {
		return findElement("//select[@id='day']");
	}

	public WebElement yearInput() {
		return findElement("//input[@id='year']");
	}

	public WebElement proceedButton() {
		return findElement("//body/div[2]/form[1]/div[2]/div[1]/input[5]");
	}

	public WebElement usernameField() {
		return findElement("//input[@id='regusername']");
	}

	public WebElement passwordField() {
		return findElement("//input[@id='password']");
	}

	public WebElement passwordConfirmField() {
		return findElement("//input[@id='passwordconfirm']");
	}

	public WebElement emailField() {
		return findElement("//input[@id='email']");
	}

	public WebElement emailConfirmField() {
		return findElement("//input[@id='emailconfirm']");
	}

	public WebElement verificationLink() {
		return findElement("//a[contains(text(),'Refresh Image')]");
	}

	public WebElement termsagreeBox() {
		return findElement("//input[@id='cb_rules_agree']");
	}

	public WebElement resetFieldsButton() {
		return findElement("//body/div[2]/form[1]/div[3]/div[1]/input[11]");
	}

	public WebElement submitButton() {
		return findElement("//body/div[2]/form[1]/div[3]/div[1]/input[10]");
	}
}
