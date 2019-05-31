package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase 
{
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement username;
	
	@FindBy(xpath="//input[@name='pwd']")
	public WebElement password;
	
	@FindBy(xpath="//a[@id='loginButton']")
	public WebElement login_button;
	
	public LoginPage(WebDriver dr)
	{
		driver=dr;
	}
	
	public EnterTimeTrackPage login(String un,String up){
		username.sendKeys(un);
		password.sendKeys(up);
		login_button.click();
		
		return PageFactory.initElements(driver, EnterTimeTrackPage.class);
	}
	
	

}
