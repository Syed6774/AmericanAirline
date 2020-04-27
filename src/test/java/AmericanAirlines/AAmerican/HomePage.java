package AmericanAirlines.AAmerican;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import Resources.BrowserInvokation;
import pageobjects.BookingPage;
import pageobjects.LandingPage;



public class HomePage extends BrowserInvokation {
	
	// We can read this from excel
	private String travelingfrom="PHL";
	private String travelingto="LCY";
	private String month="September 2020";
	private String month1="December 2020";
	private String day= "20";

	public static Logger log = LogManager.getLogger(BrowserInvokation.class.getName());
	
    @Test
	public void basepagenavigation() throws IOException, InterruptedException  {
		
	// we dont need to create browser object again.
		// we inherited the brwoserinvokation class.
driver= initializebrowser();
	driver.get("https://www.aa.com/homePage.do");
	log.info("Navigated to the American Airline Website");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	LandingPage lp= new LandingPage(driver);
			lp.getdropdown().click();
			log.info("Clicked the drop down");
			lp.clickFlightSearch().click();
			log.info("Clicked on Flight Search");
			BookingPage bp = new BookingPage(driver); 
		bp.getreedemmile().click();
		
Select ss= new Select(bp.getpassengerCount());
ss.selectByValue("2");
log.info("Selected Passenger Number");
Select pc= new Select (bp.getpessengertype());
pc.selectByVisibleText("Adult (16-64)");
log.info("Selected Passenger age");

travelfrom(driver,travelingfrom);
travelto(driver,travelingto);
selectmonth(driver,month);
selectday(driver,day);
selectmonth1(driver,month1);
selectday(driver,day);

bp.btnclick().click();

driver.quit();

}

    
    
    
    
    

public static void travelto(WebDriver driver,String travelingto) throws InterruptedException
{
	BookingPage bp= new  BookingPage(driver);
	JavascriptExecutor js= (JavascriptExecutor)driver;
	bp.getdestinationTo().clear();
	/// need change here to PHL
	bp.getdestinationTo().sendKeys(travelingto);
	Thread.sleep(3000);
	String executer1="return document.getElementById(\"segments0.destination\").value;";
	String text1=(String)js.executeScript(executer1);
	int j=0;
	while(!text1.equalsIgnoreCase(travelingto)) {
		j++;
		
		bp.getdestinationTo().sendKeys(Keys.ARROW_DOWN);
		text1=(String) js.executeScript(executer1);
		
		
		//bp.getdepartDate().click();
	}
	
}



public static void travelfrom(WebDriver driver,String travelingfrom) throws InterruptedException {
BookingPage bp= new  BookingPage(driver);
bp.getoriginfrom().clear();
bp.getoriginfrom().sendKeys("PHI");
Thread.sleep(3000);
JavascriptExecutor js= (JavascriptExecutor)driver;
String executer= "return document.getElementById(\"segments0.origin\").value;";
String text=(String) js.executeScript(executer);
int i = 0;
while(!text.equalsIgnoreCase(travelingfrom)) {
	i++;
	
	bp.getoriginfrom().sendKeys(Keys.ARROW_DOWN);
	 text=(String) js.executeScript(executer);
	 System.out.println(text);
	 if (i>10) {
		 
			log.info("Element is not found");
		 break;
	 }
}

		



		
		
	}


public static void selectmonth(WebDriver driver,String month) throws InterruptedException {
	
	BookingPage bp= new  BookingPage(driver);
	bp.getdepartDate().click();
	//driver.findElement(By.xpath("//input[@id='segments0.travelDate']")).click();
	//getdepartDate
	
	while (true) {
	String text =driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div")).getText();
		////span[contains(text(),'June')]
		
		if (text.equals(month)) {
			break;
		}else
		{
			Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
		
		}}
	
}


public static void selectday(WebDriver driver,String day) throws InterruptedException {
	
	Thread.sleep(2000);
	List <WebElement> dates=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
		int total_nodes=dates.size();
		
		for(int i=0;i<=total_nodes;i++) {
			String date=dates.get(i).getText();
			
			if(date.equalsIgnoreCase(day)) {
				dates.get(i).click();
				log.info("day has been selected-- it cam from inside a method");
				break;
			}
			
			
		}
}





public static void selectmonth1(WebDriver driver,String month1) throws InterruptedException {
	
	BookingPage bp= new  BookingPage(driver);
	bp.getreturndate().click();
	
	//driver.findElement(By.xpath("//input[@id='segments0.travelDate']")).click();
	//getdepartDate
	
	while (true) {
	String text =driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/div/div")).getText();
		////span[contains(text(),'June')]
		
		log.info(text);
		if (text.equals(month1)) {
			break;
		}else
		{
			Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
		
		}}
	
}












	private static void BookingPage() {
		// TODO Auto-generated method stub
		
	}
	    		







}

	
  
