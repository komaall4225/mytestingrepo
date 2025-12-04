package com.comcast.crm.logintest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.reports.reportManager;

import baseTest.baseClass;

public class module1_loginTest extends baseClass {
	
	
	@Test
	public void  loginValidation() {
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("inventory"), "incorrect Url"+ url);
		
	}

}
