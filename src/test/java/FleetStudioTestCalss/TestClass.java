package FleetStudioTestCalss;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FleetStudio.Contact_pom1;
import FleetStudio.Contact_pom2;

public class TestClass
{
	
	Contact_pom1 data;
	Contact_pom2 data1;
	Sheet sh;
	WebDriver driver;
	
	
	
	@BeforeClass
	public void OpenBrowser() throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("D:\\Eclipse Versions\\New folder\\MavenProject1\\TestData\\testData.xlsx");
		
	 sh =	WorkbookFactory.create(file).getSheet("Sheet1");
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse Versions\\New folder\\MavenProject1\\Browser\\chromedriver.exe" );
		
		 driver = new ChromeDriver();
		
		driver.get("https://fleetstudio.com/works/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		 data = new Contact_pom1(driver);
		  data1 = new Contact_pom2(driver);
		
	}
	
	@BeforeMethod
	public void ClickOnContactBtn() throws InterruptedException
	{
		Reporter.log("Click on contact btn");
		
		data.ContactClic();
		
	}
	
	@Test
	public void Test1() throws InterruptedException
	{
		Reporter.log("Enter Your Name",true);
		
		data1.inpname(sh.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(4000);
		
       data1.inpemail(sh.getRow(1).getCell(1).getStringCellValue());
       
		Thread.sleep(4000);
		data1.inpsub(sh.getRow(1).getCell(2).getStringCellValue());
		
	}
	
	@AfterMethod
	public void Nextpage()
	{
		Reporter.log("Nextpage");
	
	}
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException
	{
		Thread.sleep(6000);
		driver.close();
	}
	

	
}

	


