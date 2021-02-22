package pages;

import org.openqa.selenium.WebElement;

import browser.Browser;

public class BasePage {


	public static WebElement findElement(String xpath) {
		return Browser.getBrowser().findElementByXPath(xpath);
	}
	public static WebElement findElementByCss(String xpath) {
		return Browser.getBrowser().findElementByCssSelector(xpath);
	}
}
