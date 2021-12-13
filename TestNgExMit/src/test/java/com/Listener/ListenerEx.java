package com.Listener;

import java.io.File;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mit.LoginPage;


public  class ListenerEx implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
	
		System.out.println("Test case is Start with name:"+ result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
	  System.out.println("Test case is passed with name:"+result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case is fail with name:"+result.getName());
		
		
		
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case is skipped with name:"+result.getName());
	}
	@Override
	public void onStart(ITestContext context) {
	System.out.println("Test suite is satrt with name: "+context.getName());
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test suite is finish with name:"+context.getName());
	}
	
}

