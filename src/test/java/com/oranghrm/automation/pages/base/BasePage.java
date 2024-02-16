package com.oranghrm.automation.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public static WebDriver driver;

	public BasePage() {

		PageFactory.initElements(driver, this);

	}

}
