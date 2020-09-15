package com.w2a.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class HandleingFrame {
	
	public static int totalExpectedFrame = 3;
	
	@Test
	public static void frame() throws InterruptedException {
		
		// code for opening chrome browser.
		System.setProperty("webdriver.chrome.driver",".//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		//code for navigating to the URL & maximizing browser
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		// get total frameset number
		int totalframeSet= driver.findElements(By.tagName("frameset")).size();
		System.out.println("total frame set= " + totalframeSet);
		
		// get total frame number.
		
		int totalframe= driver.findElements(By.tagName("frame")).size();
		System.out.println("total frame = " + totalframe);
		
		if(totalframe==totalExpectedFrame) {
			Assert.assertTrue(true);
			System.out.println("Match with the expected frame number and the total frame number is " +totalframe);
		}else {
			System.out.println("expected frame number didn't match");
		}
		// testNG Assertion
		
		//Assert.assertEquals(totalExpectedFrame, totalframe);
			
		
		
		driver.switchTo().frame("packageListFrame");
		
		WebElement firstFrameElement = driver.findElement(By.xpath("//a[contains(text(),'All Classes')]"));
		String firstFrameText = firstFrameElement.getText();
		System.out.println("First frame text = " + firstFrameText);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		
		WebElement secondFrameElement= driver.findElement(By.xpath("//tr[1]//td[1]//a[1]"));
        String secondFrameText = secondFrameElement.getText();
        
        System.out.println("Second frame text = " + secondFrameText);
		
		
		
		
}
	 
}
