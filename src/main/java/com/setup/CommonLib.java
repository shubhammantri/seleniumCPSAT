package com.setup;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class CommonLib {
	public static WebDriver oDriver;
	@Parameters({"browserName"}) 
	@BeforeClass
	
	public void before(@Optional("")String browserName) {
		getbrowser(browserName);
	}
	public WebDriver getbrowser(String browserName) {
		
		if(browserName.equals("Chrome"))return getWebDriver(1);
		if(browserName.equals("ie"))return getWebDriver(3);
		if(browserName.equals("firefox"))return getWebDriver(2);
		
		
		return getWebDriver(1);
		
	}
	public static WebDriver getWebDriver(int num) {
		
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);
		switch (num){
		case 1:
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Exes\\chromedriver.exe");  
         oDriver=new ChromeDriver(options);
         break;
         
		case 2:
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Exes\\geckodriver.exe");
			oDriver=new FirefoxDriver();
			break;
		case 3:
			System.setProperty("webdriver.ie.driver", "Exes\\IEDriverServer.exe");
			oDriver=new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "\\Exes\\chromedriver.exe");  
	         oDriver=new ChromeDriver();
	         break;
			
		}
		return oDriver;
	}
	
}
