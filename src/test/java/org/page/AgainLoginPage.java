package org.page;
import org.global.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AgainLoginPage extends SeleniumBase {
	public AgainLoginPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[text()='Click here to login again']")
	private WebElement clickheretologin;
	public WebElement getClickheretologin() {
		return clickheretologin;
	}

}
