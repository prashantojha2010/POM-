package com.crm.qa.pages;
// Login Page
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
public class LoginPage extends TestBase{

//PageFactory-OR:

@FindBy(name="username")
WebElement username;

@FindBy(name="password")
WebElement password;

@FindBy(xpath="//input[@type='submit']")
WebElement loginButton;

@FindBy(xpath="//a[contains(text(),'Sign Up')]")
WebElement signUp;

@FindBy(xpath="//img[contains(@class,'img-responsive')]")
WebElement crmLogo;

public LoginPage() {
PageFactory.initElements(driver, this);
}

public String validateLoginTitle(){
return driver.getTitle();	
}

public boolean validateLogo(){
return crmLogo.isDisplayed();
}

public HomePage login(String un,String pwd) throws InterruptedException {
username.sendKeys(un);
Thread.sleep(3000);
password.sendKeys(pwd);
Thread.sleep(3000);
Actions action = new Actions(driver);
action.moveToElement(loginButton).click().build().perform();
Thread.sleep(3000);
//loginButton.click();
return new HomePage();
}
}
