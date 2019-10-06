package com.visionit.freecrm.hybridframework.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class BaseClassNoUsed {
	
	public static Properties prop;
	
	public static WebDriver driver;
	public BaseClassNoUsed() {
		
		try {
			File fs = new File("C:\\Users\\Admin\\eclipse-workspace\\com.visionit.freecrm.hybridframework\\src\\main\\java\\Config\\prop.properties");
			FileInputStream fis = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			System.out.println("file not found:"+ e.getMessage());
		}
	}
	 
	public static void browserStartUp(String brName, String url) {
		
		if (brName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\eclipse-workspace\\com.visionit.freecrm.hybridframework\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}   else if (brName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\com.visionit.freecrm.hybridframework\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Driver exe not able to found and hence IllegleStaeException");
		}
		driver.manage().window().maximize();
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		}
	}
	
	
	
	
	
	
	
