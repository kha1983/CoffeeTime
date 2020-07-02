package practice;

import static org.testng.Assert.assertEquals;

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

public class Priority_Test {

	WebDriver driver;

	@BeforeMethod
	public void UserWillBeAbleToOpenTheBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=login/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void UserWillAbleToLoginIntoTheSite() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=login/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		Thread.sleep(2000);

		String ExpectedTitle = "Dashboard";
		String ActualTitle = driver.getTitle();
		System.out.println("My assert starts here");

		try {
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		} catch (Throwable e) {
			System.out.println("My assert ends here");
		}
	}

	@Test(priority = 2)
	public void UserWillAbleToCreateNewAccount() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=login/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Bank & Cash")).click();
		driver.findElement(By.linkText("New Account")).click();
		driver.findElement(By.id("account")).sendKeys("KB Kathayat");
		driver.findElement(By.id("description")).sendKeys(" Keep trying please");
		WebElement element = driver.findElement(By.id("balance"));
		element.sendKeys("6600");
		element.sendKeys(Keys.ENTER);

	}

	@AfterMethod
	public void UserWillAbleToCloseTheSite() {
		driver.quit();
		driver.close();

	}

}
