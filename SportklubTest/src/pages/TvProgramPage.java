package pages;

import org.openqa.selenium.WebElement;

public class TvProgramPage extends BasePage {

	public WebElement channel2() {
		return findElement("/html[1]/body[1]/div[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/img[1]");
	}
}
