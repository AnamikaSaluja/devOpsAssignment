package TestCases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import Base.BasePage;
import Pages.AddedToCartPage;
import Pages.BookPage;
import Pages.HomePage;
import Pages.TextBook;
import Util.PropertyFileReading;

public class searches extends BasePage{
	public static WebDriverWait wait;
	
	@Test
	public void Home()
	{
		if(PropertyFileReading.getProperty("Home").equals("Y")) {
		test = rep.startTest("Home");
		test.log(LogStatus.INFO, "Starting the test");
		
		
		test.log(LogStatus.INFO, "Opened the browser");	
		test.log(LogStatus.PASS, "Screenshot ->", test.addScreenCapture("System.getProperty(\"user.dir\")+\"//screenshots//\"+screenshotFile"));
		
		
		HomePage hp = new HomePage(driver);
		hp.launch(PropertyFileReading.getProperty("url"));
		hp.clickDropDown();		
		wait = new WebDriverWait(driver,20);
        hp.searchBook();
        test.log(LogStatus.INFO, "Selected books option from drop down");
        wait = new WebDriverWait(driver,20);
        hp.EnterBookType("Selenium");        
        TextBook bookSearchPage = hp.searchButtonClick();
        test.log(LogStatus.INFO, "Found book selenium");
        wait = new WebDriverWait(driver,20);
        bookSearchPage.foundBook();
        wait = new WebDriverWait(driver,20);
        BookPage bookPage = new BookPage(driver);
        bookPage.VerifyTitle();
        test.log(LogStatus.INFO, "verified title");
        wait = new WebDriverWait(driver,20);
        bookPage.addToCartButon();
		driver.quit();
		}
		else
			driver.quit();
				
	}
	


}
