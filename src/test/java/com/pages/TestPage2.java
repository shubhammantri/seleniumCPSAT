package com.pages;
import static org.junit.Assert.assertEquals;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestPage2 {
WebDriver oDriver;
	public TestPage2(WebDriver oDriver){
	this.oDriver=oDriver;
}
	public void setNoOfAttendees() throws InterruptedException {
		By noOfAttendees = By.name("drpAttendee");

		oDriver.findElement(noOfAttendees).sendKeys("3");
		Thread.sleep(5000);
	}
	public void validateNoOfRows() {
		java.util.List<WebElement> noOfRowsOFAttendees = oDriver.findElements(By.xpath(	"//span[contains(text(),'Number of Attendee')]/../following-sibling::td//select[contains(@id,'Gridview1')]/../.."));

		assertEquals(3, noOfRowsOFAttendees.size());
	}
	public void setTitle1() {
		WebElement setTitle1 = oDriver.findElement(By.xpath("(//span[contains(text(),'Number of Attendee')]/../following-sibling::td//select[contains(@id,'Gridview1')])[1]"));
		setTitle1.sendKeys("Admiral");
	}
	public void setTitle2() {
		WebElement setTitle2 = oDriver.findElement(By.xpath("(//span[contains(text(),'Number of Attendee')]/../following-sibling::td//select[contains(@id,'Gridview1')])[2]"));
	
		setTitle2.sendKeys("CA");
		}
	public void setTitle3() {
		WebElement setTitle3 = oDriver.findElement(By.xpath("(//span[contains(text(),'Number of Attendee')]/../following-sibling::td//select[contains(@id,'Gridview1')])[3]"));
		setTitle3.sendKeys("CS");
		
	}
	public void printAllTitleOptions() {
		java.util.List<WebElement> listOfOptionsUnderTitle = oDriver.findElements(By.xpath(
				"//span[contains(text(),'Number of Attendee')]/../following-sibling::td//select[contains(@id,'Gridview1')]/option"));
		for (WebElement a : listOfOptionsUnderTitle) {
			System.out.println(a.getText());
		}
	}
}  	
