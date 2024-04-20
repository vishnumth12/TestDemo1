package Package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginValidationTest {

WebDriver driver;
	
	@Test
	public void validateLoginWithValidCredentials() {
		
		driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		WebElement usernameTf = driver.findElement(By.id("username"));
		WebElement passwordTf = driver.findElement(By.id("password"));
		usernameTf.clear();
		passwordTf.clear();
		usernameTf.sendKeys("admin");
		passwordTf.sendKeys("admin");
		
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		WebElement dashBoard = driver.findElement(By.xpath("//h4[.=' Dashboard ']"));
		
		//validation
		if(dashBoard.getText().contains("DASHBOARD")) {
			System.out.println("User is sucessfully logged in and navigated to Home Page");
		}else
		{
			System.out.println("User login Failed");
		}
		driver.close();
	}
	
	@Test
	public void validateLoginWithInValidCredentials() {
		
		driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		WebElement usernameTf = driver.findElement(By.id("username"));
		WebElement passwordTf = driver.findElement(By.id("password"));
		usernameTf.clear();
		passwordTf.clear();
		usernameTf.sendKeys("admin1");
		passwordTf.sendKeys("admin1");
		
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		WebElement errorMessage = driver.findElement(By.xpath("//span[.='Invalid credentials' and @id='validationMessage']"));
		//validation
		if(errorMessage.getText().contains("Invalid credentials")) {
			System.out.println("Login filed and Failure message is displayed");
		}else
		{
			System.out.println("Failed to display Login failure message");
		}
		driver.close();
	}
}
