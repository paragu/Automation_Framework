package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ActiveProjectAndCustomerPage  extends TestBase  {
	
	//public WebDriver driver;
	
	@FindBy(xpath="//*[@id='customersProjectsForm']/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/input[1]")
	public WebElement addnewcustomer;
	
	public ActiveProjectAndCustomerPage(WebDriver dr){
		driver=dr;
	}
	
	public CreateNewCustomer clickonnewcustomer(){
		addnewcustomer.click();
		return PageFactory.initElements(driver, CreateNewCustomer.class);
	}
	
	

}
