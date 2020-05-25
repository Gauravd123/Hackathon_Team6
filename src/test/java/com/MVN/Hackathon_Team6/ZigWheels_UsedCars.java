package com.MVN.Hackathon_Team6;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


public class ZigWheels_UsedCars extends ZigWheels_TestCase
{
	
	@Test(priority=2)
	void usedCars() throws Exception
	{
		
		Actions action1 = new Actions(driver);
		WebElement usedCars = driver.findElement(By.xpath(zp.getUsedCarsHover()));
		action1.moveToElement(usedCars).perform();
			
		 ss.takeSnapShot(driver, "./Screenshot/Used Cars In Chennai.jpg");
		 driver.findElement(By.xpath(zp.getUsedCarsInChennai())).click();
		
		
		 logger.info("Used Cars in Chennai is selected");
		 
		 if(driver.getTitle().equals(zp.getUsedCarsInChennaiTitle()))
			{
			test.log(LogStatus.PASS, "Navigated to the Used Cars in Chennai Page Successful");
			}
			else
			{
			test.log(LogStatus.FAIL, "Navigated to the Used Cars in Chennai Page Failed");
			}
		 
		 
		 
			 JavascriptExecutor jse = (JavascriptExecutor) driver;
			 jse.executeScript("window.scrollBy(0,400)");
			 
			 List<WebElement> list = driver.findElements(By.xpath(zp.getPopularModel()));
			  
			 
			 ss.takeSnapShot(driver, "./Screenshot/Popular Model.jpg");
				System.out.println("Total popular items :"+list.size());
//				/html[1]/body[1]/div[10]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[2]/div[4]/ul[1]/li[9]/label[1]
				
				for (WebElement webElement : list) {
			       String name = webElement.getText();
			        System.out.println(name);
				}
				logger.info("All Popular model is printed");
				
				driver.navigate().to(zp.getURL());
				
	}
	
	@Test(priority=3)
	void logout() throws Exception
	{
		Actions logOut = new Actions(driver);
		WebElement loginImage = driver.findElement(By.xpath(zp.getUserLogoutHover()));
		logOut.moveToElement(loginImage).perform();
		
		ss.takeSnapShot(driver, "./Screenshot/Logout.jpg");
		driver.findElement(By.xpath(zp.getlogoutClick())).click();
		
		logger.info("Logout from zigwheels.com website successful");
	}
	

	

}
