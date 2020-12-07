package seleniumAssignment;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SetSizeWindow {
	WebDriver driver;
	String url = "https://www.google.com";
	
	
	
	@Test
	public void test() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\apurva.jyoti\\git\\HSBCStuff\\seleniumAssignment\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		// getting Original Size
		Dimension d1=driver.manage().window().getSize();			
		System.out.println("Before Setting Size : "+d1);
		
		// Setting different size
		driver.manage().window().setSize(new Dimension(200,500));	
		Dimension d2=driver.manage().window().getSize();
		
		// Values after getting Size
		System.out.println("After Setting Size : "+d2);				
		System.out.println("Successful Result");
		
	}
	
	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}



}
