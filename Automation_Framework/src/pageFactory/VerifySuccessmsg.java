package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import base.TestBase;

public class VerifySuccessmsg extends TestBase 
{
	
//	public WebDriver driver;
//	public static SoftAssert st;
	@FindBy(xpath="//*[@id='SuccessMessages']/tbody/tr/td/span")
	public WebElement successmsg;
	
	@FindBy(xpath="//*[@id='logoutLink']")
	public WebElement logout;
	
	@FindBy(xpath="//*[@id='DiscardChangesButton']")
	public WebElement cancelcreation;
	
	public VerifySuccessmsg(WebDriver dr){
		driver=dr;
	}
	
	public void verifysuccessmsg()
	{
		st=new SoftAssert();
		try{
			successmsg.isDisplayed();
			logout.click();
			TestFail=false;
			//driver.quit();

		}catch(Throwable t){
			st.fail("Success message does not exists");
			logout.click();
			cancelcreation.click();
		//	driver.quit();
			TestFail=true;
		}
	}
		public void assetall(){
			if(TestFail){
			st.assertAll();
			}
		}
	}
	
	
	
	


