package com.comcast.crm.logintest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.reports.reportManager;

import baseTest.baseClass;

@Listeners(com.comcast.crm.generic.reports.reportManager.class)
public class module1_loginTest extends baseClass {
	
	
	@Test
	public void  loginValidation() {
		String url=driver.getCurrentUrl();
		Assert.assertFalse(url.contains("inventory"), "incorrect Url"+ url);
		
	}

}
