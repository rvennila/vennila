package org.page;


import org.global.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SearchHotelPage extends SeleniumBase {
	public SearchHotelPage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//select[@name='location']")
	private WebElement location;
	
	public WebElement getLocation() {
		return location;
	}
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement hotels;
	
	public WebElement getHotels() {
		return hotels;
	}
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomType;
	
	public WebElement getRoomType() {
		return roomType;
	}
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement roomNo;
	
	public WebElement getRoomNos() {
		return roomNo;
	}
	@FindBy(xpath="//input[@name='datepick_in']")
	private WebElement datePickIn;
	
	public WebElement getDatePickIn() {
		return datePickIn;
	}
	@FindBy(xpath="//input[@name='datepick_out']")
	private WebElement datePickOut;
	
	public WebElement getdatePickOut() {
		return datePickOut;
	}
	@FindBy(xpath="//select[@name='adult_room']")
	private WebElement adultRoom;
	
	public WebElement getAdultRoom() {
		return adultRoom;
	}
	@FindBy(xpath="//select[@id='child_room']")
	private WebElement childRoom;
	
	public WebElement getChildRoom() {
		return childRoom;
	}
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	public WebElement getSubmit() {
		return submit;
	}
}
