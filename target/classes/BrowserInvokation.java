package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInvokation {
	
	// Step 1 :- creating a class for browser initiation
	
	//** Create the driver object outside. If we create it inside the bracket the life will end inside the bracket.
	// if we make this access modifier as private it will not accessable outside this class.
	public WebDriver driver;
	//public Properties prop;
	public WebDriver initializebrowser() throws IOException {
		
	
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\syed\\eclipse-workspace\\AAmerican\\src\\main\\java\\Resources\\browserinfo.properties");
		prop.load(fis);
		String browsername= prop.getProperty("browser");
		
		
		
		// you can not use == when you extracting value from property. so use equelsto.== used for comparison only
		
		if (browsername.equals("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\syed\\Desktop\\Java Training\\chromedriver.exe");
			 driver= new ChromeDriver();
		}
		
	
		else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\syed\\Desktop\\Java Training\\geckodriver.exe");
			  driver=new FirefoxDriver();
		}
		
		// not doing it at test cases level instead doing it in centralized way.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// if someone wants to use this method we need to return the driver.
		
		return driver;
		
		
	}
		
		
	}
	
	
