package com.comcast.crm.generic.reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTest.baseClass;

import java.io.File;
import java.io.IOException;
import  java.util.Date;

public class reportManager implements ITestListener {
	ExtentReports report;
	ExtentSparkReporter spark;
	ExtentTest test;
	Date date;
	
	 public void onTestStart(ITestResult result) {
		  String methodname= result.getMethod().getMethodName();
	 test = report.createTest(methodname);
	 test.log(Status.INFO, methodname);
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		 test.log(Status.PASS, result.getName()+"passed");
		   
		  }
	 
	 public void onTestFailure(ITestResult result) {
		 String testname=result.getName();
		date=new Date();
		 String time=date.toString().replace(" ", "_").replace(":", "_");
		   TakesScreenshot screen=(TakesScreenshot)baseClass.edriver;
		   File srcfile=screen.getScreenshotAs(OutputType.FILE);
		   File destfile=new File("./screenshot/"+testname+"+"+time+".png");
		   try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   test.log(Status.FAIL,testname+"Test Failed").addScreenCaptureFromPath(destfile.getAbsolutePath());

		  }
	 
	 public void onStart(ITestContext context) {
		    spark=new ExtentSparkReporter("./report/reports2.html");
		    spark.config().setDocumentTitle("Testing");
		    spark.config().setReportName("Automation");
		    spark.config().setTheme(Theme.DARK);
		    report=new ExtentReports();
		    report.attachReporter(spark);
		     report.setSystemInfo("QA environment", "komal Agarwal");
		  }
	 
	 public void onFinish(ITestContext context) {
		 report.flush();
		  }
	

}
