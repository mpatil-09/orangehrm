package com.oranghrm.automation.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class OranghrmListener extends TestListenerAdapter {

	public static final Logger logger = LogManager.getLogger(OranghrmListener.class);
	public static WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {

		ITestNGMethod method = result.getMethod();
		String currentMethodName = method.getMethodName();
		logger.info(currentMethodName + "--Test execution started");

		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File("screenshots/" + currentMethodName + "-teststart.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ITestNGMethod method = result.getMethod();
		String currentMethodName = method.getMethodName();
		logger.info(currentMethodName + "--Test execution successful");

		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File("screenshots/" + currentMethodName + "testsuccess.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {

		ITestNGMethod method = result.getMethod();
		String currentMethodName = method.getMethodName();
		logger.info(currentMethodName + "--Test execution failed");

		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File("screenshots/" + currentMethodName + "testfailed.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ITestNGMethod method = result.getMethod();
		String currentMethodName = method.getMethodName();
		logger.info(currentMethodName + "--Test execution skipped");

		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File("screenshots/" + currentMethodName + "testskipped.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
