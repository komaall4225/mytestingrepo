package com.comcast.crm.logintest;

import org.testng.annotations.Test;

public class function {
	
	String browser=System.getProperty("browser");
	String url=System.getProperty("baseUrl");
	String username=System.getProperty("username");
	String password=System.getProperty("password");
	
	@Test
	public void test() {
		System.out.println(browser);
		System.out.println("url");
		System.out.println("username");
		System.out.println("password");
	}
	
	

}
