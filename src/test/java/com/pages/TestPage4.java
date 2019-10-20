package com.pages;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage4 {
public WebDriver oDriver;
public String winHandleBefore;
	public TestPage4(WebDriver oDriver){
	this.oDriver=oDriver;
}
	public void selectElectronics() throws InterruptedException {
		WebElement elecTab=oDriver.findElement(By.xpath("//a[@title='Electronics']"));
		elecTab.click();
		Thread.sleep(10000);
		
		
		
		
		
	}
	public void selectFilter() {
		WebElement colorTab=oDriver.findElement(By.xpath("//button[contains(text(),'Color')]"));
		Actions actions = new Actions(oDriver);
		actions.moveToElement(colorTab).perform();
		WebElement colorTabBlack=oDriver.findElement(By.xpath("//label[contains(text(),'Black')]"));
		
		
			actions.click(colorTabBlack).perform();
	}
	public void clickQuickView() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(oDriver, 10);
		Actions actions = new Actions(oDriver);
		
		WebElement quickView=oDriver.findElement(By.xpath("(//button[contains(text(),'QUICK VIEW')])[1]/.."));
		actions.moveToElement(quickView).perform();
		oDriver.findElement(By.xpath("(//button[contains(text(),'QUICK VIEW')])[1]")).click();
		//actions.click(quickView).perform();
		
		//quickView.click();
	}
	public void verifyProdNameContainsBlack() throws InterruptedException {
		Thread.sleep(3000);
		WebElement prodName= oDriver.findElement(By.xpath("//h1//a[contains(text(),'Black')]"));
		assertTrue(prodName.getText().contains("Black"));
		
	}
	public void verifyStillFilterIsApplied() throws InterruptedException {
		WebElement closeButton=oDriver.findElement(By.xpath("//button[@class='styles_closeButton__20ID4']"));
		closeButton.click();
		Thread.sleep(3000);
		boolean t=false;
		List<WebElement> filtersApplied=oDriver.findElements(By.xpath("//label[contains(text(),'Applied Filters')]/following-sibling::div//li"));
		for(WebElement ele:filtersApplied) {
			if(ele.getText()=="Black") {
				t=true;
			}
			
		}
		
		assertTrue(t);
	}
}  	
