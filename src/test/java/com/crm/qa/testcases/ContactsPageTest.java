package com.crm.qa.testcases;

import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class ContactsPageTest extends TestBase{
	
HomePage homepage;
LoginPage loginpage;
TestUtil testutil;
ContactsPage contactspage;
String sheetName= "contacts";

public ContactsPageTest(){
super();
}

@BeforeMethod
public void setUp() throws InterruptedException{
Initialize();
testutil = new TestUtil();
contactspage = new ContactsPage();
loginpage= new LoginPage();
homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
testutil.switchToFrame();
contactspage= homepage.clickOnContactsLink();
}

@Test(priority=1)
public void verifyContactPageLabel() {
Assert.assertTrue(contactspage.verifyContactsLabel());
}

@Test(priority=2)
public void selectSingleContactTest(){
contactspage.selectContactsByName("test test2");	
}

@Test(priority=3)
public void selectMultipleContactTest(){
contactspage.selectContactsByName("test test2");	
contactspage.selectContactsByName("ui uii");
}

@DataProvider
public Object[][] getTestData() {
 Object data[][]= TestUtil.getTestData(sheetName);
 return data;	
}

@Test(priority=4, dataProvider ="getTestData" )
public void validateCreateNewContact(String title , String firstName, String LastName, String company) {
homepage.clickOnNewContactsLink();
//contactspage.createNewContact("Mr.", "Prashant", "Ojha", "Google");
contactspage.createNewContact(title, firstName, LastName, company);
}

@AfterMethod
public void tearDown(){
driver.quit();
}
}
