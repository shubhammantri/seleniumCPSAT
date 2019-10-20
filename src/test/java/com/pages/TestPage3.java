package com.pages;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestPage3 {
WebDriver oDriver;
public String winHandleBefore;
	public TestPage3(WebDriver oDriver){
	this.oDriver=oDriver;
}
	public void clickOnTablesTab() throws InterruptedException {
		By tables = By.xpath("((//a[@role='menuitem'])[contains(text(),'Tables')])[2]");
		oDriver.manage().window().maximize();
		
		//Thread.sleep(5000);
		oDriver.findElement(tables).click();
		Thread.sleep(5000);
		oDriver.findElement(By.xpath("//*[@id='advertClose']")).click();
		
	}
	public void selectTeam() {
		WebElement team= oDriver.findElement(By.xpath("(//tr[@data-filtered-table-row-name='Arsenal']//a[@href='/clubs/1/Arsenal/overview']//span[contains(text(),'ARS') or contains(text(),'Arsenal')])[1]"));
		Actions actions = new Actions(oDriver);
		this.winHandleBefore = oDriver.getWindowHandle();
		System.out.println(winHandleBefore);
		actions.contextClick(team).perform();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
	}
	public void printTitleofNewWindow() {
		//this.winHandleBefore = oDriver.getWindowHandle();
		Set<String> winid = oDriver.getWindowHandles();
        Iterator<String> iter = winid.iterator();
        iter.next();
        String tab = iter.next();
        oDriver.switchTo().window(tab);
        System.out.println(oDriver.getTitle());
    
        
	}
	public void switchToMainWindow() {
	    oDriver.switchTo().window(winHandleBefore);
        System.out.println(oDriver.getTitle());
	}
}  	
