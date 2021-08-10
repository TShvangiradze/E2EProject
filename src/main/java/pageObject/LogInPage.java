package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	public WebDriver driver;

	@FindBy(css = "#homepage > header > div.tools > div > nav > ul > li:nth-child(4) > a > span")
	WebElement logIn;

	@FindBy(css = "#user_email")
	WebElement userName;

	@FindBy(css = "#user_password")
	WebElement password;

	@FindBy(css = "input[name='commit']")
	WebElement logInButton;

	@FindBy(css = "div[role='alert']")
	WebElement InvalidEmailText;

	public LogInPage(WebDriver driver) {

		// u're assigning live to your global variable driver:

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement logIn() {
		return logIn;
	}

	public WebElement userName() {
		return userName;
	}

	public WebElement password() {
		return password;
	}

	public WebElement logInButton() {
		return logInButton;
	}
	
	public WebElement InvalidEmailText() {
		return InvalidEmailText;
	}

}
