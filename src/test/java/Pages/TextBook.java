package Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class TextBook extends BasePage{
	
	public TextBook(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath= Constants.FOUNDBOOKTEXT)
		public WebElement foundBooktext1;

	@FindBy(xpath= "//div[@class='sg-col-inner']//div[1]//div[1]//span[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//a[1]")
	public WebElement foundBooktext;
	
	@FindBy(xpath= "//*[@id='search']/div[1]/div[2]/div/span[4]/div[2]/div[1]/div/span/div/div/div[2]/div[2]/div/div")
	public WebElement textBook;
	
	      
	    
			public BookPage foundBook()
	        {       
				foundBooktext1.click();       
			
            return new BookPage(driver);
	        }
}
