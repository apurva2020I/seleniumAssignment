package seleniumAssignment;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_Drop {
	WebDriver driver;
	String url = "https://jqueryui.com/droppable/";
	
	@Before
	public void setUp()throws Exception{
		
		//Set property according to the browser you are using
		System.setProperty("webdriver.chrome.driver","C:\\Users\\apurva.jyoti\\git\\HSBCStuff\\seleniumAssignment\\driver\\chromedriver.exe");
		//Open browser instance
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		//Start the application
		driver.get(url);
		
//		driver.quit();
	}
	
	@Test
	public void testDragDrop() {
		
		driver.switchTo().frame(0);
		//WebElement to which drag and drop operation needs to be performed
		WebElement fromElement = driver.findElement(By.id("draggable"));
		
		//WebElement on which the above object is dropped
		WebElement toElement = driver.findElement(By.id("droppable"));
		
		//Creating object of Actions Class to build Composite actions
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(fromElement,toElement).perform();
		
		String afterDragging = driver.findElement(By.id("droppable")).getText();
		
		if (afterDragging.equals("Dropped!")) {
			
			System.out.println("PASS: file is dropped as expected");
			
		}
		else {
			System.out.println("FAIL: file failed to drop as expected");
			
		}
	}
	
	@After
	public void tearDown() throws Exception{
		driver.quit();
	}
	
	

}
