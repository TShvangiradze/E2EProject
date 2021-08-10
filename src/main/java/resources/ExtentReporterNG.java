package resources;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class ExtentReporterNG {

		static ExtentReports extent;
	@BeforeTest
		public static ExtentReports getReportObject() {

			// ExtentReports , ExtentSparkReporter ->this 2 class is using to generate
			// reports

			// this code created html file and do some configuration
			String path = System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			// this is report name
			reporter.config().setReportName("Web Automation result");
			reporter.config().setDocumentTitle("Test result");
			// main class to attach complete report
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Tamuna Shvangiradze");
			return extent;
		}

		@Test
		public void initialDemo() {

			// it's Mandatory to write this code in all test
			extent.createTest("Initial Demo");

			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://google.com/");
			System.out.println(driver.getTitle());
			//should write at the end of test, it would notify that test is done, it's mondatory to add
			extent.flush();
		}

	}

	
	

