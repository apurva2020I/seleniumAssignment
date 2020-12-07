package seleniumAssignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

public class BootstrapDropdown {
	WebDriver driver;
	String url = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
	
	@Before
	public void setUp()throws Exception{
		
		//Set property according to the browser you are using
		System.setProperty("webdriver.chrome.driver","C:\\Users\\apurva.jyoti\\git\\HSBCStuff\\seleniumAssignment\\driver\\chromedriver.exe");
		//Open browser instance
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Implicit wait for 5 second
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//Start the application
		driver.get(url);
		
		
				
		
		
	}
	
	
	@Test
	public void testBootStrap()throws Exception{
		
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();
		
		List<WebElement> webElement = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container' )]//li//a//label"));
		
		for(int i = 0; i<webElement.size(); i++) {
			String val = webElement.get(i).getText();
			if (val.contentEquals("Java")||val.contentEquals("Python")) {
				
				webElement.get(i).click();
	
			}
		}
		
		
	}

}
