package Base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Util.ExtentManager;
import Util.PropertyFileReading;
import Util.Screenshots;
@Listeners(Screenshots.class)
public class BasePage {

	public WebDriver driver;
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static Actions action = null;
	String bType = null;
	SoftAssert softAssert = new SoftAssert();
	static PropertyFileReading readingPropertiesFile = new PropertyFileReading();
	public BasePage() {
		
	}
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@BeforeSuite
	public void openBrowser()
	{
		bType = PropertyFileReading.getProperty("browserName");
					
		if(bType.contentEquals("Mozilla")) {
			//System.out.println(prop.getProperty("geckodriver_exe"));
			
						System.setProperty("webdriver.gecko.driver", PropertyFileReading.getProperty("geckoDriverExe"));
			driver = new FirefoxDriver();
		
		}
		else if(bType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", PropertyFileReading.getProperty("chomeDriverExe"));
			driver = new ChromeDriver();
		}
		else if(bType.equals("IE")) {
			driver = new InternetExplorerDriver();
	}
		
		driver.manage().timeouts().implicitlyWait(PropertyFileReading.getImplicitlyWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		action = new Actions(driver);
		Screenshots.driver = driver;
		}
	
	
	
	@BeforeMethod
	public void init(){
		softAssert = new SoftAssert();
	}
	
	
	@AfterMethod
	public void quit(ITestResult result)
	{
		try{
			softAssert.assertAll();
		}catch(Error e){
			test.log(LogStatus.FAIL, e.getMessage());
		}
		if(rep!=null){
			rep.flush();
		}
		if (result.getStatus() == ITestResult.SUCCESS)
			test.log(LogStatus.PASS, "Test Case Passed");
		else if (result.getStatus() == ITestResult.FAILURE)
			test.log(LogStatus.FAIL, result.getThrowable());
		else if (result.getStatus() == ITestResult.SKIP)
			test.log(LogStatus.SKIP, result.getThrowable());

		
		
	}

	
	@AfterSuite
	public static void tearDown() {

		
	}
	
	
}
