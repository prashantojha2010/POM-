package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.TestUtil;
import com.crm.qa.utils.WebEventListener;

public class TestBase {
	
public static WebDriver driver;
public static Properties prop;
static EventFiringWebDriver e_driver;
static WebEventListener eventListener;

public TestBase() {
try
{
prop = new Properties();
FileInputStream ip =new FileInputStream("C:\\Users\\Prashant Ojha\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
prop.load(ip);	
}
catch(FileNotFoundException e){
e.printStackTrace();	
}
catch(IOException e){
e.printStackTrace();	
}
}
public static void Initialize() {
String browserName = prop.getProperty("browser");	
if(browserName.equals("chrome")){
System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
driver= new ChromeDriver();
}
if(browserName.equals("Firefox")){
System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
driver= new FirefoxDriver();
}

e_driver = new EventFiringWebDriver(driver);
eventListener= new WebEventListener();
e_driver.register(eventListener);
driver=e_driver;

driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
driver.get(prop.getProperty("url"));
}
}