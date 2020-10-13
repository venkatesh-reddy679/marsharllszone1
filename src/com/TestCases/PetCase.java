package com.TestCases;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.pages.ExcelRead;
import com.pages.ExcelWrite;
import com.utilities.WrapperClass;

public class PetCase extends WrapperClass {
	String sheetName = "petZone";
	String name = null;
	String cost = null;

	@Test

	public void f() throws InterruptedException, IOException {
		launchBrowser("chrome", "https://www.marshallspetzone.com/");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Dog"))).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Toys")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Pawzone Bone Toy For Dogs")).click();
		Thread.sleep(2000);
		name = driver.findElement(By.xpath("//span[contains(text(),'Pawzone Bone Toy For Dogs')]")).getText();
		System.out.println(name);
		String cost1 = driver.findElement(By.xpath("//div[@class='product-prices']/div[2]/div/span[1]")).getText();
		cost = cost1.substring(1, 6);

		ExcelWrite ew = new ExcelWrite();
		Thread.sleep(2000);
		ew.putCellValue1(sheetName, name);
		Thread.sleep(2000);
		ew.putCellValue2(sheetName, cost);

		driver.findElement(By.xpath("//div[@class='product-add-to-cart pt-3']/div/div[2]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='row']/div[2]/div/div/a")).click();

		ExcelRead er = new ExcelRead(driver);

		String nameStoredInExcel = er.getCellValue(sheetName, 0, 0);

		String ItemNameInCart = driver.findElement(By.xpath("//ul[@class='cart-items']/li[2]/div/div/div/div[2]/div/a"))
				.getText();
		if (ItemNameInCart.equalsIgnoreCase(nameStoredInExcel)) {
			System.out.println("ITEM NAME IN THE CART AND ITEM NAME STORED IN EXCEL ARE SAME.....................");
		}
		driver.close();

	}
}
