package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Helper {

	// create global webdriver driver once, and use it in all code, not to create
	// new object every time

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		// data driven:
		// create file, write browser's name there and by this code connect this file,
		// put it's path

		// System.getProperty(“user.dir”)
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);

		// knowledge to connect this file and get property from file:

		// String browserName = prop.getProperty("browser");

		// better way is to put browser name in maven test running process, instead of
		// get from property file
		// run from maven -> mvn test -Dbrowser=chrome

		String browserName = System.getProperty("browser");

		if (browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
			// without open the browser
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.IE.driver", "C:\\Program Files\\Java\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// name of scr should be test name
		String destenationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destenationFile));
		return destenationFile;
	}

}
