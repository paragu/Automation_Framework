package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CreateNewCustomer extends TestBase  {

//public WebDriver driver;

	
	@FindBy(xpath="//*[@id='container']/form/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/table/tbody/tr[1]/td[3]/input")
	public WebElement EnterCustomer;
	
	@FindBy(xpath="//*[@id='container']/form/table/tbody/tr[3]/td/table/tbody/tr[5]/td[2]/table/tbody/tr[2]/td[3]/textarea")
	public WebElement EnterDescription;
	
	@FindBy(xpath="//*[@id='active_customers_action']")
	public WebElement SelectRadio1;
	@FindBy(xpath="//*[@id='add_project_action']")
	public WebElement SelectRadio2;
	@FindBy(xpath="//*[@id='add_more_customers_action']")
	public WebElement SelectRadio3;
	
	@FindBy(xpath="//*[@id='container']/form/table/tbody/tr[8]/td/input[1]")
	public WebElement CreateCustomer;
	
	public CreateNewCustomer(WebDriver dr){
		driver=dr;
	}
	
	public VerifySuccessmsg createcustomer(String cname,String cdesc,String cradio){
		EnterCustomer.sendKeys(cname);
		EnterDescription.sendKeys(cdesc);
		if(cradio.equals("cradio1")){
		SelectRadio1.click();
		}else if(cradio.equals("cradio2")){
			SelectRadio2.click();
		}else if(cradio.equals("cradio3")){
			SelectRadio3.click();
		}
		CreateCustomer.click();
		
		return PageFactory.initElements(driver, VerifySuccessmsg.class);
	}
	
	
}
