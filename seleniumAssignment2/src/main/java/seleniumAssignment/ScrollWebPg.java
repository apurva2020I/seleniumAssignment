package seleniumAssignment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScrollWebPg {
	
	WebDriver driver;
	String url = "https://www.facebook.com/login/";
	
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
	public void test() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js. executeScript("window. scrollBy(0,250)");
	}
	
//	@After
//	public void tearDown() throws Exception {
//		
//		driver.quit();
//	}



}
