package AmericanAirlines.AAmerican;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.BrowserInvokation;
import junit.framework.Assert;


public class qaclickacademy extends BrowserInvokation {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BrowserInvokation.class.getName());
	
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializebrowser();
		driver.get("http://qaclickacademy.com");
		log.info("Navigated to QA Click Academy");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test(dataProvider="getData")
	public void basepagenavigation(String username,String Password) throws IOException, InterruptedException
 
	{
		
		
		driver= initializebrowser();
		
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pageobjects.loginPage lp = new pageobjects.loginPage(driver);
		/*try {
			Assert.assertEquals( lp.getelement().getText(),"Featured Course");
		}
		catch (Exception e){
			System.out.println(e);
		}*/
		
		Thread.sleep(15000);
		lp.getsignin().click();
		lp.getuserid().sendKeys(username);
		lp.getpwd().sendKeys(Password);
		lp.getloginbtn().click();
		
		

	
	}
	@AfterTest
	public void closebrowser() {
		driver.close();
		driver.quit();
	}

	@DataProvider
	
	public static Object[][] getData() {
		Object[][]data =new Object[2][2];
		data[0][0]="nonrestricteduser@gmail.com";
		data[0][1]="London6774";
		
		data[1][0]="Restricteduser@gmail.com";
		data[1][1]="London6768";
		
		return data;
		
				
		
	}
	
	
}
