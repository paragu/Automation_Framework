package testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import base.TestBase;
public class OpenAndCloseBrowser extends TestBase{

	@BeforeSuite
	public void bsuite() throws Throwable{
		initialization();
	
	}
	
	@AfterSuite
	public void asuite(){
		destroy();
	}

}
