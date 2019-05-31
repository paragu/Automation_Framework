package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class EnterTimeTrackPage extends TestBase {
	
//	public WebDriver driver;
	@FindBy(xpath="//*[@id='topnav']/tbody/tr[1]/td[5]/a/img")
	public WebElement task;
	
	public EnterTimeTrackPage(WebDriver dr){
		driver=dr;
	}
	
	public OpenTaskPage clicktask(){
		task.click();
		return PageFactory.initElements(driver, OpenTaskPage.class);
	}
}
