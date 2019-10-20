package com.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.TestPage2;
//import com.saf.framework.AutomationConstants;
import com.setup.CommonLib;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.List;

public class Test2 {
	public static WebDriver oDriver;
	
	TestPage2 TestPage=new TestPage2(oDriver);
	@BeforeClass
	public static void before() {
		// Initialise Driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shubhman\\eclipse-workspace\\SeleniumChallengeCPSAT\\Exes\\chromedriver.exe");  
        oDriver=new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver","C:\\Users\\shubhman\\eclipse-workspace\\SeleniumChallengeCPSAT\\Exes\\geckodriver.exe");
//
//		this.oDriver = new FirefoxDriver();
        
		oDriver.get("https://www.cii.in/OnlineRegistration.aspx");
		
	}
	@Test
	public void test() throws InterruptedException {
		TestPage.setNoOfAttendees();
		TestPage.validateNoOfRows();

		TestPage.setTitle1();
		TestPage.setTitle2();
		TestPage.setTitle3();
		
		TestPage.printAllTitleOptions();	
	assertTrue(true);

	}
}
