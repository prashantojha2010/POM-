package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;
public class HomePageTest extends TestBase{
	
HomePage homepage;
LoginPage loginpage;
TestUtil testutil;
ContactsPage contactspage;
	
public HomePageTest(){
super();
}

@BeforeMethod
public void setUp() throws InterruptedException{
Initialize();
testutil = new TestUtil();
loginpage= new LoginPage();
homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
}

@Test(priority=1)
public void verifyHomePageTitle(){
String homePageTitle= homepage.verifyHomePageTitle();
Assert.assertEquals(homePageTitle,"CRMPRO");	
}

@Test(priority=2)
public void verifyusernameTest() {
testutil.switchToFrame();
boolean flag=homepage.verifyCorrectUserName();
Assert.assertTrue(flag);	
}

@Test(priority=3)
public void clickContactsButton(){
testutil.switchToFrame();
contactspage=homepage.clickOnContactsLink();
}

@AfterMethod
public void tearDown(){
driver.quit();
}
}
