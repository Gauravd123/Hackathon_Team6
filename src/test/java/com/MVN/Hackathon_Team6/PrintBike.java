package com.MVN.Hackathon_Team6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintBike 
{
	
	void printBikeDetails(WebDriver driver,String xpath1,String bikePrice,String xpath2)
	{
		
		if(bikePrice.contains(","))
		{
		String bikeName = driver.findElement(By.xpath(xpath1)).getText();
		System.out.println("Bike Name : "+bikeName);
		
		System.out.println("Bike Price : Rs."+bikePrice);
		
		String bikeLaunchDate = driver.findElement(By.xpath(xpath2)).getText();
		System.out.println(bikeLaunchDate);
		}
		
		else if(bikePrice.contains("lakh"))
		{
			int index = bikePrice.indexOf("lakh");
			
			String bikePriceStr = bikePrice.substring(0, index);
		
		
			double priceD = Double.parseDouble(bikePriceStr);
	
			if(priceD<4)
			{
				String bikeName = driver.findElement(By.xpath(xpath1)).getText();
				System.out.println("Bike Name : "+bikeName);
				
				System.out.println("Bike Price : Rs."+bikePrice);
				
				String bikeLaunchDate = driver.findElement(By.xpath(xpath2)).getText();
				System.out.println(bikeLaunchDate);
				
			}
			
		}
	}

}
