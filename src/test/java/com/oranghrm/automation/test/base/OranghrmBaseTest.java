package com.oranghrm.automation.test.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import com.oranghrm.automation.listener.OranghrmListener;
import com.oranghrm.automation.utils.PropertyReader;

@Listeners(OranghrmListener.class)
public class OranghrmBaseTest {

	public static final Logger logger = LogManager.getLogger(OranghrmBaseTest.class);
	public WebDriver driver;

	@BeforeSuite
	public void init() {

		logger.info("Test execution started");
		String browserValue = PropertyReader.retrieveProperty("browser");
		logger.info("Browser value is ---" + browserValue);
		if (browserValue.equals("chrome")) {

			System.setProperty("webdriver.chromedriver", PropertyReader.retrieveProperty("chromePath"));
			logger.info("launching the chrome browser");
			driver = new ChromeDriver();

		}

		else if (browserValue.equals("edge")) {

			System.setProperty("webdriver.edgedriver", PropertyReader.retrieveProperty("edgePath"));
			logger.info("launching the edge browser");
			driver = new EdgeDriver();

		}
		
		OranghrmListener.driver=driver;

	}
	
	@AfterSuite
	public void cleanup() {
		
		logger.info("Cleaning the Browser Session");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
		
	}

}
