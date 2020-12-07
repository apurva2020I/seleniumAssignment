package seleniumAssignment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class EnterText {

	WebDriver driver;
	String url="https://www.facebook.com/login/";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\apurva.jyoti\\git\\HSBCStuff\\seleniumAssignment\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {

		WebElement email=driver.findElement(By.id("email"));
		WebElement password=driver.findElement(By.id("pass"));

		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].value='xyz@gmail.com'", email);			//arguments[0] will be replaced by email
		js.executeScript("arguments[0].value='xyz@123*'", password);
		System.out.println("Successfully Data Passed");
	}


}
