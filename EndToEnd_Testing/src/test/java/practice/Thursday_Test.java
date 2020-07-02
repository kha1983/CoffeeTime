package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Thursday_Test {

	// Steps:
	// 1. Go to http://newtours.demoaut.com/mercurywelcome.php
	// 2. Enter username: mercury
	// 3. Enter password: mercury
	// 4. Click sign-in (Hint: Incorporate implicit wait or Thread.sleep)
	// 5. Verify SIGN-OFF button displayed
	WebDriver driver;

	@Test
	public void UserWillAbeToOpenTheBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("mercury");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("mercury");
		driver.findElement(By.xpath("//*[@name='login']")).click();
		Thread.sleep(2000);

		boolean status = driver.findElement(By.linkText("SIGN-OFF")).isDisplayed();

		if (status == true) {
			System.out.println("The testing is passed");
		} else {
			System.out.println("The testing is failed and try again");
		}

		driver.close();
		driver.quit();

	}

}
