package com.w2a.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverAction {
	
	public WebDriver driver;
	public static WebElement element;
	
	
	@Test
	public static void MouseHober() throws InterruptedException {
		
		// code for opening chrome browser.
		System.setProperty("webdriver.chrome.driver",".//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		//code for navigating to the URL & maximizing browser
		driver.get("https://www.childrensplace.com/us/home");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		
		//Instantiate Action Class        
        Actions actions = new Actions(driver);
        
        //Retrieve WebElement 'baby girl' to perform mouse hover 
        WebElement menuOption = driver.findElement(By.xpath("//span[contains(@class,'nav-bar-item-label')][contains(text(),'Toddler Girl')]"));
    	
        //Mouse hover menuOption 'baby girl'
    	actions.moveToElement(menuOption).perform();
    	System.out.println("Done Mouse hover on 'baby girl' from Menu");
    	Thread.sleep(1000);
    	
    	WebElement subMenu = driver.findElement(By.xpath("//span[contains(@class,'full-width')][contains(text(),'Tops')]"));
    	actions.moveToElement(subMenu).click();
    	System.out.println("Tops clicked");
    	Thread.sleep(5000);
    	driver.quit();
    	
    	
		
	}
}
