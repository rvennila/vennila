package org.execution;
import java.io.IOException;
import org.global.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.page.AgainLoginPage;
import org.page.BookHotelPage;
import org.page.BookedItineraryPage;
import org.page.LoginPage;
import org.page.SearchHotelPage;
import org.page.SelectHotelPage;
public class TypeScript extends SeleniumBase {
	public static void main(String args[]) throws IOException, InterruptedException {
		SeleniumBase seleniumBase = new SeleniumBase();
		seleniumBase.initDriver(getDataFromExcel(1,3));
		seleniumBase.applicationLaunch(getDataFromExcel(1,2));
		seleniumBase.windMax();
		
		
				//LOGIN
		LoginPage loginPage=new LoginPage();
		WebElement username = loginPage.getUserName();
		seleniumBase.sendKeysByJava(username,getDataFromExcel(1,0));
		WebElement password = loginPage.getPassword();
		seleniumBase.sendKeysByJava(password,getDataFromExcel(1,1));
		WebElement Login = loginPage.getLogin();
		seleniumBase.clickByJava(Login);
		
				//SEARCH HOTEL
		
		SearchHotelPage searchhotelpage=new SearchHotelPage();
		WebElement location = searchhotelpage.getLocation();
		seleniumBase.selectByValue(location, getDataFromExcel(3,4));
		WebElement hotels = searchhotelpage.getHotels();
		seleniumBase.selectByValue(hotels, getDataFromExcel(3,5) );
		WebElement room_type= searchhotelpage.getRoomType();
		seleniumBase.selectByValue(room_type, getDataFromExcel(3,6) );
		WebElement room_nos =searchhotelpage.getRoomNos();
		seleniumBase.selectByVisibleText(room_nos,getDataFromExcel(3,7));
		
		WebElement CHD = driver.findElement(By.id("datepick_in"));
		CHD.clear();
		seleniumBase.sendKeysByJava(CHD,getDataFromExcel(3,8) );
		WebElement COD= driver.findElement(By.id("datepick_out"));
		COD.clear();
		seleniumBase.sendKeysByJava(COD, getDataFromExcel(3,9) );
		
			
		WebElement APR= searchhotelpage.getAdultRoom();
		seleniumBase.selectByVisibleText(APR,getDataFromExcel(2,10));
		WebElement CPR= searchhotelpage.getChildRoom();
		seleniumBase.selectByVisibleText(CPR,getDataFromExcel(2,11));

		WebElement search= searchhotelpage.getSubmit();
		seleniumBase.clickByJava(search);
		
					//SELECT HOTEL
		SelectHotelPage selectHotelPage = new SelectHotelPage();
		WebElement Radiobutton = selectHotelPage.getRadioButton();
		seleniumBase.clickByJava(Radiobutton);
		WebElement Continue = selectHotelPage.getContinue();
		seleniumBase.clickByJava(Continue);
		
				//BOOK A HOTEL

		BookHotelPage bookHotelPage=new BookHotelPage();
		WebElement first_name= bookHotelPage.getFirstName();
		seleniumBase.sendKeysByJava(first_name,getDataFromExcel(3,12));
		WebElement last_name= bookHotelPage.getlastName();
		seleniumBase.sendKeysByJava(last_name,getDataFromExcel(4,13));
		WebElement address= bookHotelPage.getAddress();
		seleniumBase.sendKeysByJava(address,getDataFromExcel(3,14));
		WebElement cc_num= bookHotelPage.getCcnum();
		seleniumBase.sendKeysByJava(cc_num,getDataFromExcel(3,15));
		
		WebElement cc_type= bookHotelPage.getCctype();
		seleniumBase.sendKeysByJava(cc_type,getDataFromExcel(3,16));
		WebElement cc_exp_month= bookHotelPage.getCcexpmonth();
		seleniumBase.sendKeysByJava(cc_exp_month,getDataFromExcel(3,17));
		WebElement cc_exp_year= bookHotelPage.getCcexpYear();
		seleniumBase.sendKeysByJava(cc_exp_year,getDataFromExcel(5,18));
		
		WebElement cc_cvv= bookHotelPage.getCcCvv();
		seleniumBase.sendKeysByJava(cc_cvv,getDataFromExcel(2,19));
		
		WebElement Itinerary =bookHotelPage.getItinerary();
		seleniumBase.clickByJava(Itinerary);
		
		
					//Booked Itinerary
		BookedItineraryPage bookeditinerarypage=new BookedItineraryPage();
		WebElement checkall = bookeditinerarypage.getCheckall();
		seleniumBase.clickByJSE(checkall);
		WebElement cancelall = bookeditinerarypage.getCancelall();
		seleniumBase.clickByJSE(cancelall);
		 
		
					//ALTERT
		seleniumBase.confirmAlert("accept");
		
						//LOGOUT
		WebElement logout = bookeditinerarypage.getlogout();
		seleniumBase.clickByJSE(logout);
		
					//click on login button
		AgainLoginPage againLoginPage = new AgainLoginPage();
		WebElement clickLogin =againLoginPage.getClickheretologin();
		seleniumBase.clickByJava(clickLogin);
		
		System.out.println("Project Is Complete");
		System.out.println("Tester Work Is Completed");

		
		
		
		

		}

}
