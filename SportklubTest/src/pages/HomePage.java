package pages;

import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {
	
	//header elements

	public WebElement searchField() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/input[1]");
	}

	public WebElement searchButton() {
		return findElementByCss(
				"body.home.page-template.page-template-page-templates.page-template-page-home-new-acf.page-template-page-templatespage-home-new-acf-php.page.page-id-580663.sk.topbar:nth-child(2) header.header:nth-child(3) div.header-bottom div.header-nav div.header-nav__desk div.header-nav__desk-wrap div.header-nav__top div.uc-container div.header-nav__top-wrap div.header-nav__top-right form.searchbox > span.searchbox-icon");
	}

	public WebElement forumButton() {
		return findElement("//a[contains(text(),'Forum')]");
	}

	public WebElement tvProgramButton() {
		return findElement(
				"//body[1]/header[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]");
	}

	public WebElement countrySelectButton() {
		return findElement(
				"//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");
	}

	public WebElement croatLanguage() {
		return findElement(
				"//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[2]/a[1]");
	}

	// navigation bar elements

	public WebElement footballNavElem() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]");
	}

	public WebElement basketballNavElem() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]");
	}

	public WebElement tenisNavElem() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]");
	}

	public WebElement automotoNavElem() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[6]/a[1]");
	}

	public WebElement volleyballNavElem() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[7]/a[1]");
	}

	public WebElement latestnewsNavElem() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]");
	} 
	public WebElement videoNavElem() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]");
	}
	public WebElement blogNavElem() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]");
	}
	public WebElement podcastNavElem() {
		return findElement("//header/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]");
	}
	
	//footer links

		public WebElement marketingLink() {
			return findElement("//body/div[5]/div[2]/footer[1]/div[2]/ul[1]/li[1]/a[1]");
		}

		public WebElement contactsLink() {
			return findElement("//body/div[5]/div[2]/footer[1]/div[2]/ul[1]/li[3]/a[1]");
		}

		public WebElement termsOfUseLink() {
			return findElement("//body/div[5]/div[2]/footer[1]/div[2]/ul[1]/li[2]/a[1]");
		}
}
