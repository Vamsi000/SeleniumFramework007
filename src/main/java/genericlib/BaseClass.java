package com.crm.genericlib;


import java.io.File;
/**
 * @author Vamsi
 */
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.Login;
import com.relevantcodes.extentreports.ExtentReports;
public class BaseClass 
{
	public static WebDriver driver;
	FileLib file=new FileLib();
	
	public ExtentReports report;
		
	@BeforeSuite
	public void configBS()
	{
		/*storing for backup purpose creating date*/
		String currdata=new Date().toString().replace(" ", "_").replace(":", "_");
		/*Generate advance report*/
		report =new ExtentReports("./advancereport/"+currdata+"extent.html");
		/*load and use setting of the extent report*/
		report.loadConfig(new File("./extent-config.xml"));
	}
	@BeforeClass
	public void preconfigBC() throws Throwable
	{
		Properties p=FileLib.getPropertyFileObject();
		String bName=p.getProperty("browser");
		if(bName.equals("firefox"))
		{
		
		System.setProperty("webdriver.gecko.driver", "./resources/geckodriver.exe");
		driver=new FirefoxDriver();
	}
		else if(bName.equals("chrome"))
		{
			System.setProperty("webdriver.gecko.driver", "./resources/chromedriver.exe");
			driver =new ChromeDriver();
		}
		
	}
	@BeforeMethod
	public void preconfigBM() throws Throwable
	{
		
		System.out.println("login");

		Properties pop=FileLib.getPropertyFileObject();
		driver.get(pop.getProperty("url"));
		//driver.get("http://localhost:8888");
		Login lp=PageFactory.initElements(driver, Login.class);
		lp.loginToApp();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	@AfterMethod
	public void postConfig() throws Throwable
	{
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		Actions ac=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		ac.moveToElement(hp.getGoTOAdmin()).perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		hp.getSignoutBtn().click();
		
	}
	
	@AfterClass
	public void postConfigBM()
	{
		
		driver.close();
	}
	
	
	@AfterSuite
	public void configAS()
	{
		report.flush();
		report.close();
	}
	
}