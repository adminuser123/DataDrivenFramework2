package com.w2a.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	// WebDriver ,properties ,logs ,excel,extent report ,email,db

	public static WebDriver driver;
	public static Properties configProperties = new Properties();
	public static Properties orProperties = new Properties();
	public static FileInputStream fis;

	@BeforeMethod
	@BeforeSuite // it will be called before executing any test so it goes before suite
	public static void setUp() throws IOException {

		if (driver == null) {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resource/properties/Config.properties");
			configProperties.load(fis);
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resource/properties/OR.properties");
			orProperties.load(fis);
			
			System.out.println("Config properties:");
			Enumeration<String> enums = (Enumeration<String>) configProperties.propertyNames();
		    while (enums.hasMoreElements()) {
		      String key = enums.nextElement();
		      String value = configProperties.getProperty(key);
		      System.out.println(key + " : " + value);
		    }
		    
		    System.out.println("Or properties:");
			enums = (Enumeration<String>) orProperties.propertyNames();
		    while (enums.hasMoreElements()) {
		      String key = enums.nextElement();
		      String value = configProperties.getProperty(key);
		      System.out.println(key + " : " + value);
		    }

			if (configProperties.getProperty("browser").equalsIgnoreCase("Firefox")) {

				System.setProperty("webdriver.geko.driver", ".//geko");
				driver = new FirefoxDriver();

			} else if (configProperties.getProperty("browser").equalsIgnoreCase("Chrome")) {

				System.setProperty("webdriver.chrome.driver", ".//chromedriver");
				driver = new ChromeDriver();

			} else if (configProperties.getProperty("browser").equalsIgnoreCase("Safari")) {

				System.setProperty("webdriver.safari.driver", ".//safari");
				driver = new SafariDriver();
			}
			driver.get(configProperties.getProperty("url"));

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(configProperties.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

		}
	}

	@AfterMethod
	@AfterSuite // it will be called executing all test which will go after suite
	public static void tearDown() {

		if (driver != null) {
			driver.quit();
		}

	}

}
