//HomePage 
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

@FindBy(xpath= "//td[contains(text(),'User: Prashant Ojha')]")
@CacheLookup
WebElement userNamelabel;

@FindBy(xpath= "//a[text()='Contacts']")
WebElement contactsLink;

@FindBy(xpath= "//a[text()='Deals']")
WebElement dealLinks;

@FindBy(xpath= "//a[text()='Tasks']")
WebElement tasksLinks;

@FindBy(xpath="//a[text()='New Contact']")
WebElement newContact;

public HomePage(){
PageFactory.initElements(driver, this);
}
public String verifyHomePageTitle() {
return driver.getTitle();
}

public boolean verifyCorrectUserName() {
return userNamelabel.isDisplayed();
}
public ContactsPage clickOnContactsLink() {
contactsLink.click();
return new ContactsPage();
}
public DealsPage clickOnDealsLink(){
dealLinks.click();
return new DealsPage();
}
public TasksPage clickOnTasksLinks(){
dealLinks.click();
return new TasksPage();
}
public void clickOnNewContactsLink() {	
Actions action = new Actions(driver);
action.moveToElement(contactsLink).build().perform();
newContact.click();
}
}


