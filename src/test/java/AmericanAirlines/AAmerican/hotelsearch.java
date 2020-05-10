package AmericanAirlines.AAmerican;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.BrowserInvokation;
import pageobjects.LandingPage;
import pageobjects.hotelpage;

public class hotelsearch extends BrowserInvokation {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BrowserInvokation.class.getName());
	
	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializebrowser();
		driver.get("https://www.aa.com/homePage.do");
		log.info("Navigated to the American Airline Website");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void searchhotel() throws InterruptedException {
		
		
		LandingPage lp= new LandingPage(driver);
		lp.getdropdown().click();
		lp.gethotelssearch().click();
		log.info("hotel search has been made.");
		
		// childwindow concept.
	
		
	
		hotelpage hp= new hotelpage(driver);
		System.out.println(driver.getTitle());
		
		// Set data structure.
		// First set will be parent window id. Second will be the immediate child
		Set<String> ids=driver.getWindowHandles();
		
		Iterator<String> it= ids.iterator();
		
		String parentid= it.next();
		String childid= it.next();
		driver.switchTo().window(childid);
		log.info("switched to child window for hotel search");
		
		hp.getloc().sendKeys("New York");
		log.info("Hotel Search Location has been set");
		driver.switchTo().window(parentid);
		log.info("Switced to parent window.");
		
		
	}
	@AfterTest
	public void closebrowser() {
		driver.close();
		driver.quit();
	}

}
