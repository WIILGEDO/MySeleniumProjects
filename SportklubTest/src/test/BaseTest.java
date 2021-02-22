package test;

import org.junit.AfterClass;


import org.junit.Before;
import org.junit.BeforeClass;

import browser.Browser;
import pages.Sportklub;

public class BaseTest {
	protected static Sportklub sportklub;

	@Before
	public void testSetup() throws InterruptedException {
		Browser.getBrowser().get("https://sportklub.rs/");
	}

	@BeforeClass
	public static void setUp() {
		sportklub = new Sportklub();
	}

	@AfterClass
	public static void cleanUp() {
		Browser.getBrowser().quit();
	}
}