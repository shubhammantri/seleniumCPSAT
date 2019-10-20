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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.TestPage2;
import com.pages.TestPage3;
//import com.saf.framework.AutomationConstants;
import com.setup.CommonLib;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.List;

public class Test3 {
	public static WebDriver oDriver;
	
	TestPage3 TestPage=new TestPage3(oDriver);
	@BeforeClass
	public static void before() throws InterruptedException {
		// Initialise Driver
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\shubhman\\eclipse-workspace\\SeleniumChallengeCPSAT\\Exes\\chromedriver.exe");  
    //    oDriver=new ChromeDriver();
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Exes\\geckodriver.exe"); 
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\shubhman\\eclipse-workspace\\SeleniumChallengeCPSAT\\Exes\\geckodriver.exe");
		oDriver = new FirefoxDriver();
        
		oDriver.get("https://www.premierleague.com/");
		Thread.sleep(1500);
		//oDriver.switchTo().defaultContent(); // you are now outside both frames
		oDriver.findElement(By.xpath("//*[@id='advertClose']")).click();
		//oDriver.switchTo().defaultContent();
		
		oDriver.findElement(By.xpath("//div[contains(text(),'I accept cookies from this site')]")).click();
		
		
	}
	@Test
	public void test() throws InterruptedException {
		TestPage.clickOnTablesTab();
		TestPage.selectTeam();
		TestPage.printTitleofNewWindow();
		TestPage.switchToMainWindow();
	assertTrue(true);

	}
	@AfterClass
	public static void after() {
		oDriver.quit();	
		}
}
