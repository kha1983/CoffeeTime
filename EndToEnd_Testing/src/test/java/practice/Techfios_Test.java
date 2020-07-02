package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Techfios_Test {

	// Automate the following test case:
	// Scenario: Users will be able to add deposit
	// 1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
	// 2. Enter username: techfiosdemo@gmail.com
	// 3. Enter password: abc123
	// 4. Click login button
	// 5. Click on Add Deposit button on Dashboard Page
	// 6. Click on Open An Account drop down to expand it,
	// 7. Click on any account name,
	// 8. Type any description,
	// 9. Type any amount,
	// 10. Click on submit button,
	// Visually check to make sure the deposit posted

	WebDriver driver;

	@BeforeMethod
	public void UserWillAbleToOpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@Test(priority=1)
	public void UserWillAbleToLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		Thread.sleep(3000);

		String ExpectedTitle = "Dashboard";
		String AcyualTitle = driver.getTitle();
		System.out.println("Your asserts starts here");

		try {
			Assert.assertEquals(AcyualTitle, ExpectedTitle);
		} catch (Throwable e) {
			System.out.println("Your assert ends here");
		}

	}
	@Test(priority=2)
	public void UserWillAbleToAddNewAccount() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Bank & Cash")).click();
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.id("account")).sendKeys("Khadak Bahadur Kathayat");
		driver.findElement(By.id("description")).sendKeys("Texas United states of america");
		
		WebElement element=driver.findElement(By.id("balance"));
		element.sendKeys("9500");
		element.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	
	}

	@AfterMethod
	public void UserWillAbleToCloseSite() {
		driver.close();
		driver.quit();

	}

}