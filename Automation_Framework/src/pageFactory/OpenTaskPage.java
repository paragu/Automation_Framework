package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class OpenTaskPage extends TestBase  {
	

//	public WebDriver driver;
	@FindBy(xpath="//*[@id='topnav']/tbody/tr[1]/td[5]/div/table/tbody/tr/td[6]/nobr/a")
	public WebElement proandcustomer;
	
	public OpenTaskPage(WebDriver dr){
		driver=dr;
	}
	
	public ActiveProjectAndCustomerPage clickongoandcustomer(){
		proandcustomer.click();
		return PageFactory.initElements(driver, ActiveProjectAndCustomerPage.class);
	}

}
