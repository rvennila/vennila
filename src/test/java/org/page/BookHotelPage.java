package org.page;

import org.global.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class BookHotelPage extends SeleniumBase{
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement firstName;
	public WebElement getFirstName() {
		return firstName;
	}
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement lastName;
	public WebElement getlastName() {
		return lastName;
	}
	@FindBy(xpath="//textarea[@name='address']")
	private WebElement address;
	public WebElement getAddress() {
		return address;
	}
	@FindBy(xpath="//input[@name='cc_num']")
	private WebElement ccNum;
	public WebElement getCcnum() {
		return ccNum;
	}
	@FindBy(xpath="//select[@name='cc_type']")
	private WebElement ccType;
	public WebElement getCctype() {
		return ccType;
	}
	@FindBy(xpath="//select[@name='cc_exp_month']")
	private WebElement ccExpMonth;
	public WebElement getCcexpmonth() {
		return ccExpMonth;
	}
	@FindBy(xpath="//select[@name='cc_exp_year']")
	private WebElement ccExpYear;
	public WebElement getCcexpYear() {
		return ccExpYear;
	}
	@FindBy(xpath="//input[@name='cc_cvv']")
	private WebElement ccCvv;
	public WebElement getCcCvv() {
		return ccCvv;
	}
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement itinerary;
	public WebElement getItinerary() {
		return itinerary;
	}
}
