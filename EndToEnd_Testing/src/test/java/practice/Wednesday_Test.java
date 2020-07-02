package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wednesday_Test {
	
	//Scenario: Users will be able to add deposit
	//1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
	//2. Enter username: techfiosdemo@gmail.com
	//3. Enter password: abc123
	//4. Click login button
	//5. Click on Add Deposit button on Dashboard Page
	//6. Click on Open An Account drop down to expand it,
	//7. Click on any account name,
	//8. Type any description,
	//9. Type any amount,
	//10. Click on submit button,
	//Visually check to make sure the deposit posted
	
	WebDriver driver;
	@Test
	public void UserWillBeAbleToFinishTest() throws InterruptedException                              {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		Thread.sleep(2000);
		
		String ExpectedTitle="Dashboard- TechFios Test Application - Billing";
		String ActualTitle=driver.getTitle();
		System.out.println("My testing start here");
		
		try   {
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		}
		catch(Throwable E)                             {
			System.out.println("My testing end here");
		}
		
		driver.findElement(By.linkText("Products & Services")).click();
		driver.findElement(By.linkText("New Service")).click();
		driver.findElement(By.id("name")).sendKeys("Khadak Bahadur Kathayat");
		driver.findElement(By.name("sales_price")).sendKeys("9900");
		driver.findElement(By.id("description")).sendKeys("Today is wednesday and almost weekend");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Products & Services")).click();
		driver.findElement(By.linkText("Services")).click();
		
		boolean status=driver.findElement(By.linkText("Today is wednesday and almost weekend")).isDisplayed();
		if(status==true)              {
			System.out.println("Your test is sucessfully passed");
		}
		else           {
			System.out.println("Your testing is failed and try again");
		}
		
		
		
		
	}

}
