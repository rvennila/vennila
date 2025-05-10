package org.page;

import org.global.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SelectHotelPage extends SeleniumBase{
	public SelectHotelPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='radiobutton_0']")
	private WebElement radiobutton;
	public WebElement getRadioButton(){
		return radiobutton;
	}
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continuebutton;
	public WebElement getContinue() {
		return continuebutton;
	}
}
