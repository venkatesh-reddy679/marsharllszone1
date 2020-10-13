package com.TestCases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.utilities.WrapperClass;

public class PetCase2 extends WrapperClass{
	
	@Test
	public void test() throws InterruptedException {
		launchBrowser("chrome", "https://www.marshallspetzone.com/");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Bird"))).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Food")).click();
		Thread.sleep(2000);
		
		String firstProductName=driver.findElement(By.linkText("Versele Laga Toma Sunflowerseed 12.5kg")).getText();
		System.out.println("name of the first product ::"+firstProductName);
		driver.findElement(By.linkText("Versele Laga Toma Sunflowerseed 12.5kg")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='product-add-to-cart pt-3']/div/div[2]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue shopping')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='iqitproductsnav']/a[1]/i")).click();
		Thread.sleep(2000);
		String secondProductName=driver.findElement(By.xpath("//span[contains(text(),'Versele Laga R Nutribird Beo Komplet 10 KG')]")).getText();
		System.out.println("name of the second product:::"+secondProductName);
		driver.findElement(By.xpath("//div[@class='product-add-to-cart pt-3']/div/div[2]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
		
		String cartItem1= driver.findElement(By.linkText("Versele Laga Toma Sunflowerseed 12.5kg")).getText();
		String cartItem2= driver.findElement(By.linkText("Versele Laga R Nutribird Beo Komplet 10 KG")).getText();
		if(firstProductName .equalsIgnoreCase(cartItem1)) {
			if(secondProductName.equalsIgnoreCase(cartItem2)) {
				System.out.println("two items which are added  to cart are present in the cart and names are verified succesfully");
			}
		}
		driver.close();
		
	}

}
