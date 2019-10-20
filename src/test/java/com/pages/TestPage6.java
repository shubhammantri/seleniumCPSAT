package com.pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class TestPage6 {
	public WebDriver oDriver;
	public TestPage6(WebDriver oDriver){
		this.oDriver=oDriver;
	}
	public ArrayList<String> readFromExcel() {
		 ArrayList<String> products=new ArrayList<String>();
		try
     {
		
         FileInputStream file = new FileInputStream(new File("Book2.xlsx"));

         //Create Workbook instance holding reference to .xlsx file
         XSSFWorkbook workbook = new XSSFWorkbook(file);

         //Get first/desired sheet from the workbook
         XSSFSheet sheet = workbook.getSheetAt(0);

         //Iterate through each rows one by one
         Iterator<Row> rowIterator = sheet.iterator();
         while (rowIterator.hasNext())
         {
             Row row = rowIterator.next();
             //For each row, iterate through all the columns
             Iterator<Cell> cellIterator = row.cellIterator();
              
             while (cellIterator.hasNext())
             {
                 Cell cell = cellIterator.next();
                 //Check the cell type and format accordingly
                 
                    
                 products.add(cell.getStringCellValue());
                         
                 
             }
             
         }
         file.close();
     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
	 return products;
    }
	public void searchProductApplyFilter(String prodName) throws InterruptedException {
		//oDriver.getTitle();
		By searchIcon=By.xpath("//div[contains(@class,'search-icon')]");
		//WebElement searchIcon = oDriver.findElement(By.xpath("//div[contains(@class,'search-icon')]"));
		WebElement searchBox=oDriver.findElement(By.xpath("//input[@id='searchkey']"));
		
		WebElement searchButton=oDriver.findElement(By.xpath("//input[@id='searchBtn']"));
		
		oDriver.findElement(searchIcon).click();
		searchBox.sendKeys(prodName);
		
		searchButton.click();
		Thread.sleep(5000);
		WebElement highToLowFilter=oDriver.findElement(By.xpath("//input[@id='prcHTL_sort']/following-sibling::label"));
		highToLowFilter.click();
		
	}
	public void validateProductPricesDescending() {
		List<WebElement> prodPrice=oDriver.findElements(By.xpath("//section[contains(@class,'categoryProduct')]//span[@class='mrp']"));
		int count =8;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(WebElement elements :prodPrice) {
			
			//System.out.println(elements.getText());
			arr.add(Integer.parseInt(elements.getText().substring(2)));
			count--;
			if(count==0) {
				break;
			}
		}
		assertTrue(priceComparison(arr));
		
	}
	public boolean priceComparison(ArrayList<Integer> Arr) {
		int j=1;
		for(int i : Arr) {
			
			if(i>=Arr.get(j)) {
				//System.out.println(i +" "+Arr.get(j));
				if(j==7) {
					return true;
				}
				
			}
			j++;
//			
		}
		return false;
	}
	
	
}
