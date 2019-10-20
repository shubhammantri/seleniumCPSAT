package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert; 
public class TestPage1 {
	
	public WebDriver oDriver;
	public TestPage1(WebDriver oDriver){
		this.oDriver=oDriver;
	}
	
	
	
	public void printHeightWidthOfLogo() {
		
		WebElement ImageLogo = oDriver.findElement(By.xpath("//img[@title='Meripustak Online bookstore']"));
	      //Get width of element.
	      int ImageWidth = ImageLogo.getSize().getWidth();
	      System.out.println("Image width Is "+ImageWidth+" pixels");
	      
	      //Get height of element.
	      
	      int ImageHeight = ImageLogo.getSize().getHeight();        
	      System.out.println("Image height Is "+ImageHeight+" pixels");
	     
	}
	public void printHrefOfTwitter() {
		 String hrefOfTwitter;
	      WebElement element= oDriver.findElement(By.xpath("//*[contains(text(),'Follow Us')]/../a[contains(@href,'twitter')]"));
		 hrefOfTwitter = element.getAttribute("href"); 
		 System.out.println(hrefOfTwitter);
	}
	public void clickShoppingCartItemZero() {
		WebElement noCartItems = oDriver.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]//span[@id='lblNoCartItem']"));
		 System.out.println(noCartItems.getText());
		 	 if(noCartItems.getText().contains("0"))
		  {
			  noCartItems.click();
			  
			  WebElement msgCartEmpty=oDriver.findElement(By.xpath("(//div[@class='book_description box_border']//table//table)[2]//h4"));
				 String msgCart=msgCartEmpty.getText();
				 System.out.println(msgCart);

			  
			  Assert.assertTrue(msgCart.equals("No Item is Added In Cart yet.Cart is Empty!!!"));
			 
		  }
	}
	public void addJavaBookToCart() throws InterruptedException {
		WebElement home=oDriver.findElement(By.xpath("//a[@href='https://www.meripustak.com']"));
		home.click(); 
		WebElement searchBox=oDriver.findElement(By.xpath("//input[@id='txtsearch']"));
		searchBox.click();
		searchBox.sendKeys("Java");
		WebElement searchButton=oDriver.findElement(By.xpath("//a[@id='btnsearch']"));
		searchButton.click();
		WebElement javaBookTitle=oDriver.findElement(By.xpath("(//div[@id='book_list']//li//span[@itemprop='name'])[contains(text(),'Java')]/../../following-sibling::div/a[contains(text(),'Add to Cart')]"));
		javaBookTitle.click();
		Thread.sleep(1000);
	}
	public void verifyCartNotEmpty() {
		WebElement noCartItems = oDriver.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]//span[@id='lblNoCartItem']"));
		 noCartItems.click();
		 WebElement msgCart=oDriver.findElement(By.xpath("((//div[@class='book_description box_border']//table//table)[2]//a)[1]"));
		 String msgCartText=msgCart.getText();
		 System.out.println(msgCartText);
		 Assert.assertFalse(msgCartText.equals("No Item is Added In Cart yet.Cart is Empty!!!"));

	}
}
