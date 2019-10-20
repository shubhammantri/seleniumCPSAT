package com.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.TestPage2;
import com.pages.TestPage3;
import com.pages.TestPage4;
//import com.saf.framework.AutomationConstants;
import com.setup.CommonLib;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

public class Test4 {
	public static WebDriver oDriver;
	

	@BeforeClass
	public static void before() throws InterruptedException {
		
		// Initialise Driver
		//Create a map to store  preferences 
				Map<String, Object> prefs = new HashMap<String, Object>();

				//add key and value to map as follow to switch off browser notification
				//Pass the argument 1 to allow and 2 to block
				prefs.put("profile.default_content_setting_values.notifications", 2);

				//Create an instance of ChromeOptions 
				ChromeOptions options = new ChromeOptions();

				// set ExperimentalOption - prefs 
				options.setExperimentalOption("prefs", prefs);
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Exes\\chromedriver.exe");  
        oDriver=new ChromeDriver(options);
        oDriver.manage().window().maximize();
		
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\shubhman\\eclipse-workspace\\SeleniumChallengeCPSAT\\Exes\\geckodriver.exe");
		//oDriver = new FirefoxDriver();
        
		
		
		
		
	}
	@Test
	public void test() throws InterruptedException {
		TestPage4 TestPage=new TestPage4(oDriver);
		oDriver.get("https://www.hometown.in/");
		Thread.sleep(10000);
		TestPage.selectElectronics();
		TestPage.selectFilter();
		TestPage.clickQuickView();
		TestPage.verifyProdNameContainsBlack();
		TestPage.verifyStillFilterIsApplied();
	assertTrue(true);

	}
	@AfterClass
	public static void after() {
		oDriver.quit();	
		}
}
