package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Object is define at the top and method at the bottom.
public class loginPage {

	// I NEED TO HANDLE THE POP UP

	@FindBy(id="user_email")
	WebElement userid;
	@FindBy(id="user_password")
	WebElement password;
	@FindBy(name="commit")
	WebElement loginbtn;
	@FindBy(linkText="Login")
	private	WebElement signin;
		@FindBy(xpath="/html/body/section[2]/div/a")
	private	WebElement linkexist;
	 private @FindBy (xpath="div[class*='video-banner'] h3")
	 WebElement findtitle;
	 
	 private @FindBy(xpath="//h2[contains(text(),'Featured Courses')]")

	 WebElement featuredcourse;
	
	public WebDriver driver;
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		// driver object which has life is passed here.
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	


	// A method can not be without return type.
	public WebElement getuserid()
	{
		return userid;
		}
	public WebElement getpwd()
	{
		return password;
	}
	public WebElement getloginbtn()
	{
		return loginbtn;
	}
	
	public WebElement getsignin()
	{
		return signin;
			}
	public WebElement getlinktext()
	{
		return linkexist;
	}
	public WebElement gettitle()
	{
		return findtitle;
	}
	public WebElement getelement() {
		return featuredcourse;
	}
}
