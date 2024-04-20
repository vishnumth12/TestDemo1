package Package1;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CloseNthWindowTest {

	@Test
	public void closeTheNthWindow() {
		WebDriver driver;
		//Change1
		String BROWSER = System.getProperty("browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} 
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Invalid browser");
		}
		
		int i = 1;
		LinkedList<String> li = new LinkedList<>();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys(i+"th Window");
		for(int j = 2; j<=10; j++) {
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys(j+"th Window");
		}
		Set<String> windowHandles = (LinkedHashSet<String>) driver.getWindowHandles();
	
		for(String window : windowHandles) {
			System.out.println(window);
			li.add(window);
		}
		String seventh = li.get(6);
		driver.switchTo().window(seventh);
		driver.close();
	}
}
