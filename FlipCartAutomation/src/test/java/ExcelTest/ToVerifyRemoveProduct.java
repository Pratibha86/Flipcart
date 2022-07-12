package ExcelTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browser.Base;
import pom.AddToCartHeadPhones;
import pom.HomePageFlipcarth;
import pom.LoginPageFlipcart;
import pom.ProductPageFlipcart;
import pom.RemoveProduct;
import utilis.Utility;

public class ToVerifyRemoveProduct {
	    
	
	
	
	    WebDriver driver;
	    LoginPageFlipcart loginPageFlipcart;
	    HomePageFlipcarth homePageFlipcarth;
	    ProductPageFlipcart productPageFlipcart;
	    AddToCartHeadPhones addToCartHeadPhones;
	    RemoveProduct removeProduct;
	    int testID;
	    
	    static ExtentTest test;
		static ExtentHtmlReporter reporter;
	    @Parameters("browserName")
	    
		   @BeforeTest 
		   public void lunchBrowser(String browser) {
			   System.out.println("Before Test");
			   reporter = new ExtentHtmlReporter("test-output/ExtentReport/Extent.html");
				ExtentReports extend = new ExtentReports();
				extend.attachReporter(reporter);
			   
			   if(browser.equals("Chrome"))
			   {
				   driver= Base.openChromeBrowser();
			   }
			   if(browser.equals("Opera"))
			   {
				 driver= Base.openOperaBrowser();
			  }
			   
			   driver.manage().window().maximize();	
			   //u can add the wait here
		   }
		   
	    
	@BeforeClass
	    public void beforeClass() {
		 loginPageFlipcart=new LoginPageFlipcart(driver);
		 homePageFlipcarth=new HomePageFlipcarth(driver); 
		 productPageFlipcart= new ProductPageFlipcart(driver);
		 addToCartHeadPhones=new AddToCartHeadPhones(driver);
	     removeProduct= new RemoveProduct(driver);
	     }
    @BeforeMethod
           public void beforeMethod() throws EncryptedDocumentException, IOException {
	       driver.get("https://www.flipkart.com/");
	       String username=Utility.getDataFromExcel("Flipcart", 0, 1);
   		   loginPageFlipcart.sendMobileId(username);
   		   
   		   String password=Utility.getDataFromExcel("Flipcart", 1, 1);
   		   loginPageFlipcart.sendPasswordId(password);
   		   
   		   loginPageFlipcart.clickOnLogin();
   		   
          }
     @Test(priority=1)
            public void testToSelcectProduct() throws InterruptedException {
    	    System.out.println("test c");
    	    
    	    testID=104;
    	    homePageFlipcarth.SelectElectronicsDropdown();
    	    homePageFlipcarth.SelectbluetoothHeadphone();
    	    
    	   
        	productPageFlipcart.selectminPrice();
        	productPageFlipcart.selectmaxPrice();
            productPageFlipcart.clickHeadPhones();
        	
        	
        	 }
     
       @Test ( priority=2,dependsOnMethods= {"testToSelcectProduct"})
     public void testToRemoveProduct() throws InterruptedException {
    	
    	testID=103;
       	Thread.sleep(3000);
        System.out.println("test d");
       	addToCartHeadPhones.selectaddToCart();
       	String url1=driver.getCurrentUrl();
       	String title1=driver.getTitle();
       	//hard assert...if verification gets failed it will not execute further test methods
       	Assert.assertEquals(title1, "realme Buds Air 2 with Active Noise Cancellation (ANC) Bluetooth Headset Price in India - Buy realme Buds Air 2 with Active Noise Cancellation (ANC) Bluetooth Headset Online - realme : Flipkart.com", "title verification failed");;
       
    	removeProduct.clickOnRemoveProduct();
        removeProduct.clickonremovebutton();
    
       }
       
       @AfterMethod
         public void afterMethod(ITestResult result) throws InterruptedException, IOException {
    	   Thread.sleep(3000);
    	   
    	   System.out.println( "After method");
			if(ITestResult.FAILURE==result.getStatus())
			{
				Utility.captureScreen(driver,testID);
			}
			Thread.sleep(2000);
		 
    	homePageFlipcarth.clickToLogout();
    	
          }
       @AfterClass
       public void closedObjects() {
    	   System.out.println("after class");
    	   
    	 loginPageFlipcart=null;
  		 homePageFlipcarth=null;
  		 productPageFlipcart= null;
  		 addToCartHeadPhones=null;
  	     removeProduct= null;
    	   
           }
    @AfterTest
        public void afterClass() {
        System.out.println("after test");
    	driver.quit();
    	driver=null;
    	System.gc();
        }
}
