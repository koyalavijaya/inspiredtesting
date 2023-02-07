package inspiredtesting;
import java.util.Iterator;

import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Inspiredtesting {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		System.setProperty(

		"webdriver.chrome.driver",

		"D:\\ChromeDriver\\chromedriver.exe");

		// Instantiate a ChromeDriver class.

		WebDriver driver = new ChromeDriver();

		String URL="https://www.takealot.com/";

		// Open URL and Maximize browser window

		driver.get(URL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		//search for soap

		driver.findElement(By.className("search-field")).sendKeys("soap");

		driver.findElement(By.className("search-field")).sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//open one of the selected soap

		driver.findElement(By.xpath("//div[@id='34144859']")).click();

		//driver.findElement(By.xpath("//a[@href='/dettol-175g-hygiene-soap-hand-body-re-energise/PLID34144859']")).click();

		Set<String> ids = driver.getWindowHandles();

		Iterator<String> it = ids.iterator();

		String parentId = it.next();

		String childId = it.next();

		driver.switchTo().window(childId);

		//Click on add to cart
		WebElement AddtoCartButton = driver.findElement(By.xpath("//*[text()='Add to Cart']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", AddtoCartButton);

		 		//driver.findElement(By.xpath()).click();

		
		
		System.out.print("Added to cart");

		String confirmationMessage = driver.findElement(By.xpath("//*[text()='Added to cart']")).getText();

		// Verify that Product is added to cart

		if (confirmationMessage.equals("Added to cart")) {

		System.out.println(": Pass");

		}

		else {

		System.out.println(": Fail");

		}

		driver.quit();

		}
}
