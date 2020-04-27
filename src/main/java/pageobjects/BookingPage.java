package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
	
	public WebDriver driver;
	@FindBy (xpath=("//input[@id='segments0.origin']"))
	private  WebElement originfrom;
	
	
	@FindBy (xpath=("//input[@id='segments0.destination']"))
	
	private WebElement destinationTo;
	@FindBy (xpath=("//a[@id='ui-id-3']"))
	private WebElement enableRoundTrip;
	@FindBy(xpath=("//div[@id='redeemMiles']/div/label/span"))
	private WebElement redeemmile;
	@FindBy(xpath=("//input[@id='segments0.travelDate']"))
	private WebElement travelDate;
	
	@FindBy (xpath=("//input[@id='segments1.travelDate']"))
	private WebElement returndate;
	@FindBy(xpath=("//div[@id='departTimeSection']/label/select"))
	private WebElement departTime;
	@FindBy(xpath=("//select[@id='segments1.travelTime']"))
	private WebElement returntime;
	@FindBy(xpath=("//select[@id='passengers0.passengerType']"))
	private WebElement pessengertype;
	@FindBy(xpath=("//select[@id='passengerCount']"))
	private WebElement passengerCount;
	@FindBy(xpath=("//button[@id='flightSearchSubmitBtn']"))
	private WebElement clickbutton;
	
	
	
	
	public BookingPage(WebDriver driver) {
		
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public WebElement getreedemmile() {
		return redeemmile;
	}
	
	public WebElement getreturntime() {
		return returntime;
	}
	public WebElement getreturndate() {
		return returndate;
	}
	
	
	public WebElement getdepartTime() {
		return departTime;
	}
	
	
	public WebElement getpessengertype()
	{
		return pessengertype;
	}
	
	public WebElement getrndtrip() {
		
		return enableRoundTrip;
		
	}
	
	public WebElement getpassengerCount() {
		return passengerCount;
	}
	
	
	public WebElement getdepartDate() {
		
		return travelDate;
	}
	
	public WebElement getdestinationTo() {
		
		return destinationTo;
	}
	
	public WebElement btnclick() {
		return clickbutton;
	}
	
	public WebElement getoriginfrom() {
		
		return originfrom;
	}

}
