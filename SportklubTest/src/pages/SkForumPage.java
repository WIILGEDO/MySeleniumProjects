package pages;

import org.openqa.selenium.WebElement;

public class SkForumPage extends BasePage {

	public WebElement registrationButton() {
		return findElement("//a[contains(text(),'Register')]");
	}
}
