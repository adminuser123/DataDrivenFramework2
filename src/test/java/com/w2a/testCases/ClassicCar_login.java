package com.w2a.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassicCar_login {
	
	public WebDriver driver;
	public static String email= "murshida.metu@gmail.com";
	public static  String pass= "Selenium1";
	public static WebElement element;
	public static String expectedUser ="Hi, murshida!";
	
	
	@Test
	public static void loginAccount() throws InterruptedException {
		
		// code for opening chrome browser.
		System.setProperty("webdriver.chrome.driver",".//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		//code for navigating to the URL & maximizing browser
		driver.get("https://classiccars.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		driver.manage().window().maximize();
		
		// code for click action using selenium
		driver.findElement(By.xpath("//a[@id='UserLoginJumperLink']")).click();
		
		// code for writing something in Text box using sendkey method in selenium
		driver.findElement(By.xpath("//div[@id='UserLoginCard']//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//div[@id='UserLoginCard']//input[@id='input-password']")).sendKeys(pass);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='login']")).submit();
		
		//code for extracting any text from UI using get text method
		element = driver.findElement(By.xpath("//a[@id='UserNameAccountLink']"));
		Thread.sleep(1000);
		String actualUIUser = element.getText();
		System.out.println("Actual user in UI = " + actualUIUser);
		
		// code for validation using if else condition
		if(actualUIUser.equals(expectedUser)) {
			Assert.assertTrue(true);
			System.out.println("Application user = " +actualUIUser+ "matches with the given expected user = " + expectedUser);
		}else {
			System.out.println("Application user = " +actualUIUser+ "do not match with the given expected user = " + expectedUser);
			AssertJUnit.fail();
		}
		
		 Assert.assertEquals(actualUIUser, "Hi");
		
		
		/*driver.findElement(By.xpath("//a[@id='navFind']")).click();
		driver.findElement(By.xpath("//input[@id='YearFrom']")).sendKeys("2015");
		
		
		//code for clearing existing value from test box using clear method 
		driver.findElement(By.xpath("//input[@id='YearTo']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='YearTo']")).sendKeys("2020");
		
		// code for selecting desire value from dropdown
		element = driver.findElement(By.xpath("//select[@id='Model']"));
		Select select = new Select(element);
		//select.deselectByVisibleText("Acura");
		select.selectByVisibleText("Acura");
		
				
		
		element= driver.findElement(By.xpath("//input[@id='refine-search-button']"));
				element.click();
		
		driver.close();
		driver.quit();*/
		
		
		
		
		
		
		
		
		
	}

}
