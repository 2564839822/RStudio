package SSP;

//*****************************************************************************************************************************************
//Revision History: 	0001
//Date:				08/17/2017
//Author:			Kedra Bell
//Reason of Change: Initial Release
//Purpose: Verify all the objects on the SSP form page and SSP download page are correctly displayed
//*****************************************************************************************************************************************


import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GUI {
	  
	  Logger logger = Logger.getLogger(CommonFunctions.class.getName());
		//****************************************************************************************************************************************
		//Purpose: The purpose of this testcase is to ensure all fields are displayed in the form. There's also a screenshot taken to verify other
		//objects on the page. There is also also manual testcases to cover complete SSP download functionality.
		//****************************************************************************************************************************************
	 @Test
	public void VerifyGuiObjects() {
		 System.setProperty("webdriver.gecko.driver","C:/Users/ksb/Downloads/geckodriver-v0.18.0-win32/geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		 driver.get("https://www.rstudio.com/products/shiny-server-pro/evaluation/.");
		 
		 	WebElement txtfname = driver.findElement(By.id("FirstName"));
	        WebElement txtlname = driver.findElement(By.id("LastName"));
	        WebElement txtemail = driver.findElement(By.id("Email"));
	        WebElement txtcomapany = driver.findElement(By.id("Company"));
	        WebElement txtcountry = driver.findElement(By.id("Country"));
	        WebElement btnDownload = driver.findElement(By.xpath("//button[@type='submit']"));
		 
		 if (txtfname.isDisplayed() && txtlname.isDisplayed() && txtemail.isDisplayed() && txtcomapany.isDisplayed() && txtcountry.isDisplayed() && btnDownload.isDisplayed()) {
			logger.log(null, "PASSED - ALL OBJECTS IN THE FORM ARE DISPLAYED");
			 //take screenshot
		 }
		 driver.close();
	        //logger notes to junit testcase results and execute the email send out in jenkins
	 }

}
