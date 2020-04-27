package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	
	public WebDriver driver;
	
	@FindBy(xpath=("//button[@id='plan-travel-expander']"))
	
	private WebElement plantravebtn;
	
	@FindBy(xpath=("//div[@id='plan']/ul/li[1] //*[contains(text(),'Flights')]"))
	
	private WebElement FlightSearch;
	
	@FindBy(xpath=("//button[@id='flightSearchSubmitBtn']"))
	private WebElement clicksubmit;
	
	@FindBy(xpath=("//div[@id='plan']/ul/li[2] //*[contains(text(),'Hotels')]"))
	private WebElement HotelsSearch;
	
			
	
	
	
	
// HOW THE GETTER AND SETTERS WORK HERE??
	
	
	

public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	// this variable is created inside the class.
	
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
	}


public WebElement gethotelssearch() {
	
	return HotelsSearch;
}

public WebElement getdropdown() {
	
	return plantravebtn;
	
}

public WebElement clicksubmit() {
	
	return clicksubmit;
}

public WebElement clickFlightSearch() {
	return FlightSearch;
}






}
