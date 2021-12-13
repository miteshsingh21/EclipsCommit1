package com.mit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Listener.ListenerEx;
@Listeners(ListenerEx.class)
public class LoginPage {
	public static WebDriver driver;
	@BeforeMethod
	public void Setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Seleniumjar/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		
	}
	@AfterMethod
	public void teardown() {
		
		driver.close();
	}
		
 @Test
  public void Test01() {
	// String ActTitle = "Book bus tickets online with redBus!";
	 String ExpTitle = "Amazon.com. Spend less. Smile more.";
	Assert.assertEquals(driver.getTitle(), ExpTitle);
 }
 @Test
 public void test02() {
	 
	 boolean b1 = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
	 System.out.println(b1);
	 
 }
 @Test(dataProvider="logintest",dataProviderClass=com.Utility.DataTest.class)
 public void Test03(String uname,String pass,String Title) {
	 
	 WebElement t1 = driver.findElement(By.xpath("//a[@id = 'nav-link-accountList']"));
	 WebElement t2 = driver.findElement(By.xpath("//span[@class='nav-action-inner']"));
	 Actions act = new Actions(driver);
	 act.moveToElement(t1).click(t2).pause(2000).build().perform();
	 driver.findElement(By.id("ap_email")).sendKeys(uname);
	 driver.findElement(By.id("continue")).click();
	 driver.findElement(By.id("ap_password")).sendKeys(pass);
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 Assert.assertEquals(driver.getTitle(), Title);
	 
 }
	 
 
	 
  
}
