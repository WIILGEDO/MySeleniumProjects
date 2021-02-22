package test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import browser.Browser;
import pages.Sportklub;

public class BaseTest2 {
	protected static Sportklub sportklub;

	@Before
	public void testSetup() throws InterruptedException {
		Browser.getBrowser().get("http://www.sportklub.info/forum/activity.php?langid=1");
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
