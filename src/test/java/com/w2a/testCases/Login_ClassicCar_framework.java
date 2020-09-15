package com.w2a.testCases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class Login_ClassicCar_framework extends TestBase {
	
	@Test
	public static void login() {
		
		driver.findElement(By.xpath(orProperties.getProperty("userLoginLink"))).click();
		
	}

}
