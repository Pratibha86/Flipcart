package ExcelTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browser.Base;
import pom.AddToCartHeadPhones;
import pom.HomePageFlipcarth;
import pom.LoginPageFlipcart;
import pom.ProductPageFlipcart;
import pom.RemoveProduct;
import utilis.Utility;

public class ToVerifySelectedProduct {
	   
	    WebDriver driver;
	    LoginPageFlipcart loginPageFlipcart;
	    HomePageFlipcarth homePageFlipcarth;
	    ProductPageFlipcart productPageFlipcart;
	    AddToCartHeadPhones addToCartHeadPhones;
	    RemoveProduct removeProduct;
	    SoftAssert soft;
	    int testID;
	    
	    @Parameters("browserName")
	    
	   @BeforeTest 
	   public void lunchBrowser(String browser) {
		   System.out.println("Before Test");
		   if(browser.equals("Chrome"))
		   {
			   driver= Base.openChromeBrowser();
		   }
		   if(browser.equals("Opera"))
		   {
			 driver= Base.openOperaBrowser();
		  }
		   driver.manage().window().maximize();	   
	   }
	   
	@BeforeClass
	    public void beforeClass() {
		  loginPageFlipcart=new LoginPageFlipcart(driver);
		  homePageFlipcarth=new HomePageFlipcarth(driver); 
		  productPageFlipcart= new ProductPageFlipcart(driver);
	   
	     }
    @BeforeMethod
           public void beforeMethod() throws EncryptedDocumentException, IOException {
	       driver.get("https://www.flipkart.com/");
	       
	       String username=Utility.getDataFromExcel("Flipcart", 0, 1);
   		   loginPageFlipcart.sendMobileId(username);
   		   
   		   String password=Utility.getDataFromExcel("Flipcart", 1, 1);
   		   loginPageFlipcart.sendPasswordId(password);
   		   
   		   loginPageFlipcart.clickOnLogin();
   		   
   		   soft=new SoftAssert();
          }
     @Test(invocationCount=2)
            public void testToSearchProduct() throws InterruptedException {
    	    testID=102;
    	    System.out.println("test A");
    	    homePageFlipcarth.SelectElectronicsDropdown();
    	    homePageFlipcarth.SelectbluetoothHeadphone();
    	    
    	    String url1=driver.getCurrentUrl();
        	String title1=driver.getTitle();
        	//System.out.println(url1);
        	//System.out.println(title1);
        	if(title1.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
             {
    	        System.out.println("pass");
             }
             else
             {
            	 System.out.println("fail"); 
             }
           
     }
     
       @Test ( priority=2)
           public void testToSelectProduct() throws InterruptedException {
    	   
    	   testID=101;
    	   
    	homePageFlipcarth.SelectElectronicsDropdown();
   	    homePageFlipcarth.SelectbluetoothHeadphone();
    	
    	
       	productPageFlipcart.selectminPrice();
       	productPageFlipcart.selectmaxPrice();
       	Thread.sleep(7000);
       
       	productPageFlipcart.clickHeadPhones();
       	String url1=driver.getCurrentUrl();
    	String title1=driver.getTitle();
    	//System.out.println(url1);
    	//System.out.println(title1);
    	
    	
    	soft.assertEquals(title1, "Headphones - Up to 80% Off on Headphones, Headset, Earphones Online | Free Delivery", "verification failed");
        soft.assertAll();
    	    }
       
       @AfterMethod
        
    	   
    	   public void afterMethod(ITestResult result) throws InterruptedException, IOException {
    			
    			System.out.println( "After method");
    			if(ITestResult.FAILURE==result.getStatus())
    			{
    				Utility.captureScreen(driver,testID);
    			}
    			Thread.sleep(4000);
    			
    	homePageFlipcarth.clickToLogout();
    	
          }
       
       @AfterClass
       public void clearObject()
       {
    	   System.out.println("after class");
    	  loginPageFlipcart=null;
 		  homePageFlipcarth=null;
 		  productPageFlipcart= null;
       }
       
    @AfterTest
        public void closedBrowser() {
        System.out.println("after test");
    	driver.quit();
    	driver=null;
    	System.gc();
        }
    
    

}
