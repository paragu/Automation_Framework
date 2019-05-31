package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pageFactory.ActiveProjectAndCustomerPage;
import pageFactory.CreateNewCustomer;
import pageFactory.EnterTimeTrackPage;
import pageFactory.LoginPage;
import pageFactory.OpenTaskPage;
import pageFactory.VerifySuccessmsg;
import xls.ShineXlsReader;

public class TestCreateCustomerflow extends TestBase {
	
	@BeforeMethod
	public void btest(){
		if(!ht.get("Test123").equalsIgnoreCase("yes")){
			throw new SkipException("This testcase is set no for execution....");
		}
	}
	
	@Test(dataProvider="getdata")
	public void testcase1(String cname,String cdesc,String cradio){
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		EnterTimeTrackPage entertimetrackpage=loginpage.login("admin", "manager");
		OpenTaskPage opentaskpage=entertimetrackpage.clicktask();
		ActiveProjectAndCustomerPage  activeproandcustpage=opentaskpage.clickongoandcustomer();
		CreateNewCustomer  createnewcustomer=activeproandcustpage.clickonnewcustomer();
		VerifySuccessmsg verifysuccessmsg=createnewcustomer.createcustomer(cname, cdesc, cradio);
		verifysuccessmsg.verifysuccessmsg();
		verifysuccessmsg.assetall();
		
		
	}
	
	@DataProvider
	public static Object[][] getdata(){
		ShineXlsReader xls=new ShineXlsReader(System.getProperty("user.dir")+"\\src\\utility\\DataPool.xlsx");
		int rcount=xls.getRowCount("Test1");
		int ccount=xls.getColumnCount("Test1");
		Object obj[][]=new Object[rcount-1][ccount];
		for(int i=2;i<=rcount;i++){
			for(int j=0;j<ccount;j++){
				obj[i-2][j]=xls.getCellData("Test1", j, i);
			}
		}
		
		return obj;
	}

}
