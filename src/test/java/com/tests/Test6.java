package com.tests;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.TestPage6;
import com.setup.CommonLib;

public class Test6 extends CommonLib{
	

	@Parameters({"browserName"}) 
	@BeforeClass
	public void before(@Optional("")String browserName) {
		getbrowser(browserName);
		
		
	}
	@Test
	public void validation() throws InterruptedException{
		
		TestPage6 TestPage=new TestPage6(oDriver);
		ArrayList products;
		oDriver.manage().window().maximize();
		oDriver.get("https://www.woodlandworldwide.com/");
		
		products=TestPage.readFromExcel(); //read Data from Excel
		
		//Test for bags 
		TestPage.searchProductApplyFilter(products.get(1).toString());
		TestPage.validateProductPricesDescending();
		
		//Test For shoes
		TestPage.searchProductApplyFilter(products.get(2).toString());
		TestPage.validateProductPricesDescending();
		//Test for tshirt
		TestPage.searchProductApplyFilter(products.get(3).toString());
		TestPage.validateProductPricesDescending();
	}
	@AfterClass
	public void After() {
		oDriver.quit();
	}
	
}
