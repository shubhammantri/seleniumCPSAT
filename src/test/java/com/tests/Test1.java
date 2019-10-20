package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.pages.TestPage1;
import com.setup.CommonLib;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test1 extends CommonLib{
	@Parameters({"browserName"}) 
	@BeforeClass
	public void before(@Optional("")String browserName) {
		getbrowser(browserName);
	}
	@Test
	public void validation() throws InterruptedException {
	
	  oDriver.get("https://www.meripustak.com/"); 
	  TestPage1 TestPage=new TestPage1(oDriver);
	 TestPage.printHeightWidthOfLogo();
	  
     TestPage.printHrefOfTwitter();
	 TestPage.clickShoppingCartItemZero();
	 TestPage.addJavaBookToCart();	
	 TestPage.verifyCartNotEmpty();
//	Actions actions=new Actions(oDriver);
//	WebElement shoppingCart=oDriver.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]//span[@id='lblNoCartItem']"));
//	
//	actions.contextClick(shoppingCart).perform();
	
	
	}
	
	@AfterClass
	public void After() {
		oDriver.quit();
	}

}
