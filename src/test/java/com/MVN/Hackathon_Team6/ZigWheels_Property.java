package com.MVN.Hackathon_Team6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ZigWheels_Property 
{
	
	static Properties pro;
	public void properties() throws IOException
	{
	
		pro = new Properties();
		FileInputStream file = new FileInputStream("E:\\Source Codes\\Hackathon_Team6\\ZigWheels_property.properties");
		pro.load(file);
    
	}

	public String getChromeDriver()
	{
		return pro.getProperty("chromeDriver");
	}

	
	public String getGeckoDriver()
	{
		return pro.getProperty("geckoDriver");
	}
	
	public String getURL()
	{
		return pro.getProperty("websiteURL");
	}
	
	public String getUserLogin()
	{
		return pro.getProperty("userLogin");
	}
	
	public String getGoogleLogin()
	{
		return pro.getProperty("googleLogin");
	}
	
	public String getEmailIdLogin()
	{
		return pro.getProperty("emailXpath");
	}
	
	public String getInvalidEmailId()
	{
		return pro.getProperty("invalidEmailId");
	}
	
	public String getEmailNext()
	{
		return pro.getProperty("emailNext");
	}
	
	public String getErrorXpath()
	{
		return pro.getProperty("errorXpath");
	}
	
	public String getValidEmailId()
	{
		return pro.getProperty("validEmailId");
	}
	
	public String getPasswordXpath()
	{
		return pro.getProperty("passwordXpath");
	}
	
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	
	public String getPasswordNext()
	{
		return pro.getProperty("passwordNext");
	}
	
	public String getPopupClose()
	{
		return pro.getProperty("popupClose");
	}
	

	
	
	public String getNewBikes()
	{
		return pro.getProperty("newBikes");
	}
	
	public String getUpcomingBikes()
	{
		return pro.getProperty("upcomingBikes");
	}
	
	public String getUpcomingHondaBikes()
	{
		return pro.getProperty("hondaBikes");
	}
	
	public String getHomePageTitle()
	{
		return pro.getProperty("homePageTitle");
	}
	
	public String getUpcomingBikesTitle()
	{
		return pro.getProperty("upcomingBikesTitle");
	}
	
	public String getUpcomingHondaBikesTitle()
	{

		return pro.getProperty("upcomingHondaBikesTitle");
	}
	
	public String getUsedCarsInChennaiTitle()
	{

		return pro.getProperty("usedCarsInChennaiTitle");
	}
	
	public String getUsedCarsHover()
	{
	
		return pro.getProperty("usedCarsHover");
	}
	
	public String getUsedCarsInChennai()
	{
	
		return pro.getProperty("usedCarsInChennai");
	}
	
	public String getPopularModel()
	{
	
		return pro.getProperty("popularModel");
	}
	
	public String getUserLogoutHover()
	{
	
		return pro.getProperty("userLogoutHover");
	}
	
	public String getlogoutClick()
	{
	
		return pro.getProperty("logoutClick");
	}

}
