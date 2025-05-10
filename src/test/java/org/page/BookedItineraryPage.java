package org.page;

import org.global.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedItineraryPage extends SeleniumBase {
	public BookedItineraryPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//input[@id='check_all']")
		private WebElement checkall;
		
		public WebElement getCheckall(){
			return checkall;
	}
		
		@FindBy(xpath="//input[@name='cancelall']")
		private WebElement cancel;
		
		public WebElement getCancelall() {
			return cancel;
		}
		@FindBy(xpath="//input[@id='logout']")
			private WebElement logout;
		
		public WebElement getlogout() {
			return logout;
			
		}
}
