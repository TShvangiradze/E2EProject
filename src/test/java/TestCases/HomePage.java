package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LogInPage;
import resources.Helper;

//in order to get methods from helper/base class, should use "extends" in class , or create object of it
public class HomePage extends Helper {

	@BeforeTest
	public void initializebrowser() throws IOException {
		driver = this.initializeDriver();
		// Parameterize url too
		driver.get(prop.getProperty("URL"));
	}

	@Test
	public void basePageNavigation() throws IOException {

		LogInPage lp = new LogInPage(driver);
		lp.logIn().click();

	}

	@AfterTest
	public void testEnd() {
		driver.quit();
	}

}
