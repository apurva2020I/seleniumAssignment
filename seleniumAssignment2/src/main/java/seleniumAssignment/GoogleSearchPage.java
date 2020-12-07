package seleniumAssignment;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearchPage {
	
	WebDriver driver;
	String url = "https://www.google.com";
	
	@Before
	public void setUp()throws Exception{
		
		//Set property according to the browser you are using
		System.setProperty("webdriver.chrome.driver","C:\\Users\\apurva.jyoti\\git\\HSBCStuff\\seleniumAssignment\\driver\\chromedriver.exe");
		//Open browser instance
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Start the application
		driver.get(url);
		
	}

	
	
	@Test
	public void test() throws InterruptedException 
	{
		driver.findElement(By.name("q")).sendKeys("Selenium");

		List<WebElement> ele=driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));

		for(int i=0;i<ele.size();i++) 
		{
			String value=ele.get(i).getText();
			if(value.contains("selenium tutorial"))
			{
				Thread.sleep(5000);
				ele.get(i).click();
				break;
			}
		}

	}

}
