package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getData(String key) throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "//configAppData//commonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
	}
	}


