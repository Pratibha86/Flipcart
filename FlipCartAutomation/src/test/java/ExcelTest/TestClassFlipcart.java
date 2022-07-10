package ExcelTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.HomePageFlipcarth;
import pom.LoginPageFlipcart;
import pom.ProductPageFlipcart;
import utilis.Utility;

public class TestClassFlipcart {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		System.setProperty("webdriver.chrome.driver","F:\\Ashish Java Lecture\\Manual notes\\chromedriver.exe");
				
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.flipkart.com/");
				driver.manage().window().maximize();
				
				LoginPageFlipcart loginPage=new LoginPageFlipcart(driver);
				String username=Utility.getDataFromExcel("Flipcart", 0, 1);
		   		   loginPage.sendMobileId(username);
		   		   
		   		   String password=Utility.getDataFromExcel("Flipcart", 1, 1);
		   		   loginPage.sendPasswordId(password);
		   		   
		   		   loginPage.clickOnLogin();
				
				HomePageFlipcarth homePageFlipcarth= new HomePageFlipcarth(driver);
			//	homePageFlipcarth.SelectelectronicsDropdown();
				homePageFlipcarth.SelectbluetoothHeadphone();
				
				ProductPageFlipcart productPageFlipcart=new ProductPageFlipcart(driver);
				productPageFlipcart.selectminPrice();
				productPageFlipcart.selectmaxPrice();
				productPageFlipcart.clickHeadPhones();
	}
	
}
