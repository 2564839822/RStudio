package SSP;
//*****************************************************************************************************************************************
//Revision History: 	0001
//Date:				08/17/2017
//Author:			Kedra Bell
//Reason of Change: Initial Release
//Purpose: The purpose of this document is to house all common functions used for SSP testing
//*****************************************************************************************************************************************
import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonFunctions {
	static ArrayList<Integer> browserList = new ArrayList<Integer>();
	public static WebDriver mDriver = null;
	public static final String mUrl = "https://www.rstudio.com/products/shiny-server-pro/evaluation/.";
    static Logger logger = Logger.getLogger(CommonFunctions.class.getName());
    static Random randomizer = new Random();
    static Integer randomBrowser;  
    static java.util.Date date = Calendar.getInstance().getTime();
    static Date currentdate;
 
    //returns the current date
    public static String getCurrentDate() {
    	 DateFormat dateFormat = new SimpleDateFormat("MM/dd");
  	   Calendar cal = Calendar.getInstance();
  	   logger.log(null, "Current date was calculated");
  	   
	return dateFormat.format(cal.getTime());
    }
    
    //take screenshot
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination
                File DestFile=new File(fileWithPath);
                //Copy file at destination
                FileUtils.copyFile(SrcFile, DestFile);
    }

 
    //open random browser  
	public static void getBrowser() {
		// TODO Auto-generated method stub
		browserList.add(1); //internet explorer
		browserList.add(2); //chrome
		browserList.add(3); //Firefox
		randomBrowser = browserList.get(randomizer.nextInt(browserList.size()));
		if (randomBrowser.equals(1)) {
			System.setProperty("webdriver ie driver", "C:/Users/ksb/Downloads/IEDriverServer_Win32_3.4.0 (2)/IEDriverServer.exe");
			mDriver = new InternetExplorerDriver();
		} 
		if (randomBrowser.equals(2)) {
			System.setProperty("chrome webdriver","C:/Users/ksb/Downloads/chromedriver_win32/chromedriver.exe");
			mDriver = new ChromeDriver();
		}
		if (randomBrowser.equals(3)) {
			System.setProperty("webdriver.gecko.driver","C:/Users/ksb/Downloads/geckodriver-v0.18.0-win32/geckodriver.exe");
			mDriver = new FirefoxDriver();
		}
	
		mDriver.get(mUrl);
		logger.log(null, "Random Browser was opened");
		//geckodriver was the only jar file included IE and Chrome will not work bc needed driver was not packaged.
		
	}
	
	//generate and send test results
			//CREATE A JUNIT ANT TASK DURING THE BUILD AND HAVE JENKINS RUN IT...I didn't have time to finish this function and the build.xml file
			//this could also be setup in jenkins....it depends on the project setup and team pref
}
