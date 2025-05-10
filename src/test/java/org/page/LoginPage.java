package org.page;

import org.global.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends SeleniumBase {
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='username']")
	private WebElement userName;
	
	public WebElement getUserName() {
		return userName;
	}
	@FindBy(xpath="//input[@id='password']")
	private WebElement passWord;
	
	public WebElement getPassword() {
		return passWord;
	}
	@FindBy(xpath="//input[@type='Submit']")
	private WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
	

}
