package com.mystore.base;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BasClass {
	public static WebDriver driver;
	public static Properties prop;
	@BeforeTest(groups = {"Smoke","Sanity","Regression"})
    public void loadConfig() throws IOException {
		
        //if (driver == null) {
		try {
			prop = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Confirguration\\config.properties");
            prop.load(file);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	     @Parameters("browser")
         public static void launchApp(String browserName) {  
            //String browserName = prop.getProperty("browser");
            System.out.println(browserName);
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            else if (browserName.equalsIgnoreCase("IE")) {
                driver = new InternetExplorerDriver();
            }
            
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
         }
	     public String getScreenshot(String testName,WebDriver driver) throws IOException {
		    	TakesScreenshot ts = (TakesScreenshot)driver;
		    	File source = ts.getScreenshotAs(OutputType.FILE);
		    	File file = new File(System.getProperty("user.dir")+"//reports//"+testName+".png");
		    	FileUtils.copyFile(source, file);
				return file.getAbsolutePath();
		    }
}

	

