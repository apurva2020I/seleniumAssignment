package assertion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment1 {

	WebDriver driver;
	String url="https://accounts.google.com/signup";

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\apurva.jyoti\\git\\HSBCStuff\\seleniumAssignment\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

//	@After
//	public void tearDown() throws Exception {
//		driver.close();
//	}

	@Test
	public void test() throws InterruptedException {

		WebElement firstname=driver.findElement(By.id("firstName"));
		firstname.sendKeys("apurva");
		String fname=firstname.getAttribute("value");
		System.out.println("First Name : "+fname);						// Printing the First name Written

		WebElement lastname=driver.findElement(By.id("lastName"));
		lastname.sendKeys("jyoti");
		String lname=lastname.getAttribute("value");
		System.out.println("Last Name : "+lname);						// Printing the Last name Written

		driver.findElement(By.id("username")).sendKeys("apurva123demo");						

		WebElement password=driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input"));
		password.sendKeys("abcdef!@2345");
		String confirmpassword=password.getAttribute("value");

		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys(confirmpassword);

		driver.findElement(By.id("accountDetailsNext")).click();		// Next Button Click event

		if(!(driver.getCurrentUrl()=="https://accounts.google.com/signup" || driver.getCurrentUrl().contains("SignUp")))
		{
			if(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div[2]/div[3]")).isDisplayed()) 
			{
				String s1=driver.findElement(By.xpath("//*[@id=\"usernameList\"]/li[1]/button")).getText();
				String s2=driver.findElement(By.xpath("//*[@id=\"usernameList\"]/li[2]/button")).getText();
				String s3=driver.findElement(By.xpath("//*[@id=\"usernameList\"]/li[3]/button")).getText();
				driver.findElement(By.id("username")).clear();
				driver.findElement(By.id("username")).sendKeys(s1);
				driver.findElement(By.id("accountDetailsNext")).click();		// Next Button Click event

			}
			else
			{
				driver.findElement(By.id("username")).clear();
				driver.findElement(By.id("username")).sendKeys("LearnAtDemo");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/span/span")).click();
			}


		}

		String txt=driver.getCurrentUrl();
		Thread.sleep(3000);
		Assert.assertTrue(txt.contains("accounts.google.com"));				// Assertion used for checking if it contains string"phone number"
			System.out.println("Successful");
	}

}
