package DynamicWebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AllCheckBoxes {
	
	@Test
	public void allCheckBoxes()
	{
		// Login To The Application
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// Navigate To Organization Module
		driver.findElement(By.linkText("Organizations")).click();
		
		// Click on All Organaization which are Present In Organization Module
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody[1]/tr[*]//input[@type='checkbox']")).click();
		System.out.println("All Organizations are Clicked Succcesfully ---> PASS");
		
		// LogOut From The Applicaion
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		// Closing The Browser Window
		driver.quit();
		
		
	}

}
