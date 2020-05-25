package com.MVN.Hackathon_Team6;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.Logger;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class ZigWheels_TestCase 
{
	
	public static final Logger logger = LogManager.getLogger(ZigWheels_TestCase.class);
	static ExtentTest test;
	static ExtentReports report;
	
	PrintBike pb = new PrintBike();
	Screenshot ss = new Screenshot();
	Read_Excel_Xpath rex = new Read_Excel_Xpath();
	static ZigWheels_Property zp = new ZigWheels_Property();
 	//public static Logger logger;
 	
	WebDriver driver;
	
	
	 @BeforeTest
	 @Parameters("browser")
	  void setupDriver(String browser) throws Exception
	  {
		 zp.properties();
		
		 // logger=Logger.getLogger("ZigWheels_TestCase");
		  //PropertyConfigurator.configure("Log4j.properties");
		
		 report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		 test = report.startTest("ZigWheels_TestCase");
		 
		 if(browser.equalsIgnoreCase("firefox"))
			{
				//create firefox instance
				System.setProperty(zp.getGeckoDriver(),System.getProperty("user.dir")+"//Drivers//geckodriver.exe" );
			    FirefoxOptions options = new FirefoxOptions();
			    driver = new FirefoxDriver(options);
			    logger.info("Firefox is opened");
				
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				System.setProperty(zp.getChromeDriver(),System.getProperty("user.dir")+"//Drivers//chromedriver.exe" );
				//create chrome instance
				driver = new ChromeDriver();
				//display the appropriate functioning 
				 logger.info("Google Chrome is opened");
			}
			
				else{
					//If no browser passed throw exception
					throw new Exception("Browser is not correct");//handling exceptions
				}
		 
		
		  
	  }
	  
	  @BeforeClass
	  void openBrowser() throws Exception
	  {
				
		  
		 driver.get(zp.getURL());
		 driver.manage().window().maximize();
		 
	
		 if(driver.getTitle().equals(zp.getHomePageTitle()))
			{
			test.log(LogStatus.PASS, "Navigated to the HomePage Successful");
			}
			else
			{
			test.log(LogStatus.FAIL, "Navigated to the HomePage Failed");
			}
		 
	
		 ss.takeSnapShot(driver, "./Screenshot/Home Page.jpg");
		  
	  }
	  
		@Test(priority=0)
		void googleLogin() throws Exception
		{
			driver.findElement(By.xpath(zp.getUserLogin())).click();
			Thread.sleep(7000);
			
			 ss.takeSnapShot(driver, "./Screenshot/Google Login.jpg");
			//div[@class='h-s-v1 u-icn-w u-n-l c-p']//img
			//div[@id='des_lIcon']//img[@id='forum_login_cover_image_sm']
			driver.findElement(By.xpath(zp.getGoogleLogin())).click();
			//div[@id='googleSignIn']//span[2]
			//span[contains(text(),'Continue with Google')]
			Thread.sleep(10000);
			
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			
			WebElement email = driver.findElement(By.xpath(zp.getEmailIdLogin()));
			//input[@id='identifierId']
			//input[@name='identifier']

			//html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input
			email.sendKeys(zp.getInvalidEmailId());
			
			 ss.takeSnapShot(driver, "./Screenshot/Invalid Email Id.jpg");
			WebElement next = driver.findElement(By.xpath(zp.getEmailNext()));
			next.click();
			logger.info("Invalid Email id is entered");
			
			
			Thread.sleep(3000);
			WebElement errMsg = driver.findElement(By.xpath(zp.getErrorXpath()));
			
			 ss.takeSnapShot(driver, "./Screenshot/Error Message.jpg");
			System.out.println("\nError Message :"+errMsg.getText());
			
			logger.info("Error Message successfully captured and printed in the console");
			
			email.clear();
			Thread.sleep(2000);
			email.sendKeys(zp.getValidEmailId());
			
			ss.takeSnapShot(driver, "./Screenshot/Valid Email Id.jpg");
			logger.info("Valid Email id is entered");
			next.click();
	     
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath(zp.getPasswordXpath())).sendKeys(zp.getPassword());
			
			 ss.takeSnapShot(driver, "./Screenshot/Password.jpg");
			Thread.sleep(3000);
			driver.findElement(By.xpath(zp.getPasswordNext())).click();
			logger.info("Password entered");
			
			driver.switchTo().window(tabs2.get(0));
			
			logger.info("Login with google successful");
			
			
			Thread.sleep(15000);
			WebElement close =driver.findElement(By.xpath(zp.getPopupClose()));
			close.click();
					
		}
	  
	  @Test(priority=1)
	  void search() throws Exception 
	  {
		  String excelXpath[] = rex.readFromExcel();
		  logger.info("ZigWheels website is opened");
		  Actions action = new Actions(driver);
		  WebElement applian = driver.findElement(By.xpath(zp.getNewBikes()));
		  action.moveToElement(applian).perform();
			
		  driver.findElement(By.xpath(zp.getUpcomingBikes())).click();
			 
			 logger.info("Upcoming Bikes is selected");
			 
			 if(driver.getTitle().equals(zp.getUpcomingBikesTitle()))
				{
				test.log(LogStatus.PASS, "Navigated to the Upcoming Bikes Page Successful");
				}
				else
				{
				test.log(LogStatus.FAIL, "Navigated to the Upcoming Bikes Page Failed");
				}
			 
			
			 ss.takeSnapShot(driver, "./Screenshot/Upcoming Bikes.jpg");
			 Select drpCountry = new Select(driver.findElement(By.xpath(zp.getUpcomingHondaBikes())));
				drpCountry.selectByVisibleText("Honda");

				
				logger.info("Honda bike is selected");
				
				 if(driver.getTitle().equals(zp.getUpcomingHondaBikesTitle()))
					{
					test.log(LogStatus.PASS, "Navigated to the Upcoming Honda Bikes Page SuccessfulL");
					}
					else
					{
					test.log(LogStatus.FAIL, "Navigated to the Upcoming Honda Bikes Page Failed");
					}
				 
				 
				 JavascriptExecutor jse = (JavascriptExecutor) driver;
				 jse.executeScript("window.scrollBy(0,200)");
				
				 ss.takeSnapShot(driver, "./Screenshot/Honda Upcoming Bikes.jpg");
				System.out.println("\n");
				
			String bikePrice1 = driver.findElement(By.xpath(excelXpath[1])).getText();
		
			String bikeName1 = excelXpath[0];
				
			String bikeLaunchDate1 = excelXpath[2];
		
			pb.printBikeDetails(driver, bikeName1, bikePrice1, bikeLaunchDate1);
			
			
			System.out.println("\n");
			
			String bikePrice2 = driver.findElement(By.xpath(excelXpath[4])).getText();
			
			String bikeName2 = excelXpath[3];
			
			String bikeLaunchDate2 = excelXpath[5];
	
		pb.printBikeDetails(driver, bikeName2, bikePrice2, bikeLaunchDate2);
		
		
		System.out.println("\n");
		
		String bikePrice3 = driver.findElement(By.xpath(excelXpath[7])).getText();
		
		String bikeName3 = excelXpath[6];
		
		String bikeLaunchDate3 = excelXpath[8];

		pb.printBikeDetails(driver, bikeName3, bikePrice3, bikeLaunchDate3);
			
			
	System.out.println("\n");
	
	String bikePrice4 = driver.findElement(By.xpath(excelXpath[10])).getText();
	
	String bikeName4 = excelXpath[9];
	
	String bikeLaunchDate4 = excelXpath[11];

	pb.printBikeDetails(driver, bikeName4, bikePrice4, bikeLaunchDate4);
	
	System.out.println("\n");
	
		 
	}
	  
	  @AfterClass
	  void closeBrowser() throws InterruptedException 
	  {
		  Thread.sleep(3000);
		  driver.close();
		  report.endTest(test);
		  report.flush();
		
	  }

}
