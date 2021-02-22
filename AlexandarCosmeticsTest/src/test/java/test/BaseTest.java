package test;

import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;

import browser.Browser;
import pages.AlexandarCosmetics;

public class BaseTest {
	protected static AlexandarCosmetics alexandarCosmetics;

	@Before
	public void testSetup() throws InterruptedException {
		Browser.getBrowser().get("https://www.alexandar-cosmetics.com/en/");
	}
	

	@BeforeClass
	public static void setUp() {
		alexandarCosmetics = new AlexandarCosmetics();
	}

	@AfterClass
	public static void cleanUp() {
		Browser.getBrowser().quit();
	}
}
