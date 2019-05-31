package base;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.asserts.SoftAssert;

import xls.ShineXlsReader;

public class TestBase {
	public static WebDriver driver=null;
	public static FileInputStream fip=null;
	public static Properties prop=null;
	public static Logger APP_LOGS=null;
	public static SoftAssert st=null;
	public static boolean TestFail=false;
	public static int temp=0;
	public static ShineXlsReader Mxls;
	public static Hashtable<String ,String> ht;
	
	
	public static void initialization() throws Throwable{
		APP_LOGS=Logger.getLogger("devpinoyLogger");
		st=new SoftAssert();
		fip=new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\Or.Properties");
		APP_LOGS.debug("fileinputsteam command executed ");
		prop=new Properties();
		prop.load(fip);
		APP_LOGS.debug("properties file is loaded");
		String browser=prop.getProperty("browsertype");
		
		if(browser.equalsIgnoreCase("mozilla")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver= new FirefoxDriver();
			APP_LOGS.debug("Mozilla fire fox browser started");
		}
		else if (browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			APP_LOGS.debug("InternetExplorer browser started");
		} else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			APP_LOGS.debug("Chrome browser started");
		}
		driver.get("http://localhost:9000/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	public static void destroy(){
		driver.close();
		APP_LOGS.debug("closed the current application");
		driver.quit();
		APP_LOGS.debug("closed browser");
		
	}
	
	public static void moduledriver(){
		ht=new Hashtable<String,String>();
		Mxls=new ShineXlsReader(System.getProperty("user.dir")+"\\src\\utility\\Moduledriver.xlsx");
		int TotalModules = Mxls.getRowCount("Mainsheet");
		for(int i=2;i<=TotalModules;i++){
			String ModuleName = Mxls.getCellData("Mainsheet", 0, i);
			String Exestatus = Mxls.getCellData("Mainsheet", 1, i);
			
			if(Exestatus.equalsIgnoreCase("yes")){
				 int Totaltecases = Mxls.getRowCount(ModuleName);
				for(int j=2;j<=Totaltecases;j++){
					String TestId = Mxls.getCellData(ModuleName, 0, j);
					String Runstatus = Mxls.getCellData(ModuleName, 1, j);
					ht.put(TestId, Runstatus);
				}
				
		
	
}
}
	}
}