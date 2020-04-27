package AmericanAirlines.AAmerican;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.BrowserInvokation;
import junit.framework.Assert;


public class qaclickacademy extends BrowserInvokation {
	
	public static Logger log = LogManager.getLogger(BrowserInvokation.class.getName());
	
	
	@Test(dataProvider="getData")
	public void basepagenavigation(String username,String Password) throws IOException, InterruptedException
 
	{
		
		
		driver= initializebrowser();
		
		driver.get("http://qaclickacademy.com");
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
