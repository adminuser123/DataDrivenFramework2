package com.w2a.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertAndHardAssert {
	
	
	@Test
	public void hardAssert() {
		
		Assert.assertEquals(5, 5);
		System.out.println("1. hard assert success....");
		
		Assert.assertTrue("Hello".equals("hello"));
		Assert.assertTrue("Welcome".equals("welcomeeee"));
		System.out.println("1.1  test case one executed successfully ***");
	}

	@Test
	public void softAssert() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(5,5);
		System.out.println(" 2. Soft assert success....");
		
		softAssert.assertTrue("Hello".equals("hello"));
		softAssert.assertTrue("Welcome".equals("welcomeeee"));
		System.out.println("2.2 test case two executed successfully ***");
		softAssert.assertAll();
	}

}
