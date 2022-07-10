package ExcelTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.AddToCartHeadPhones;
import pom.HomePageFlipcarth;
import pom.LoginPageFlipcart;
import pom.ProductPageFlipcart;
import pom.RemoveProduct;
import utilis.Utility;

;

public class ToVerifyLoginPageFlipcart {
	    WebDriver driver;
	    LoginPageFlipcart loginPageFlipcart;
	    HomePageFlipcarth homePageFlipcarth;
	    ProductPageFlipcart productPageFlipcart;
	    AddToCartHeadPhones addToCartHeadPhones;
	    RemoveProduct removeProduct;
	    
	@BeforeClass
	    public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "F:\\Ashish Java Lecture\\Manual notes\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	     }
    @BeforeMethod
           public void beforeMethod() throws EncryptedDocumentException, IOException {
	       driver.get("https://www.flipkart.com/");
	       loginPageFlipcart=new LoginPageFlipcart(driver);
	       String username=Utility.getDataFromExcel("Flipcart", 0, 1);
   		   loginPageFlipcart.sendMobileId(username);
   		   
   		   String password=Utility.getDataFromExcel("Flipcart", 1, 1);
   		   loginPageFlipcart.sendPasswordId(password);
   		   
   		   loginPageFlipcart.clickOnLogin();
   		   loginPageFlipcart.clickOnLogin();
   		   homePageFlipcarth=new HomePageFlipcarth(driver); 
          }
     @Test()
            public void testToLogin() throws InterruptedException {
    	    System.out.println("test A");
    	    homePageFlipcarth.SelectElectronicsDropdown();
    	    homePageFlipcarth.SelectbluetoothHeadphone();
    	    
    	    String url1=driver.getCurrentUrl();
        	String title1=driver.getTitle();
        	System.out.println(url1);
        	System.out.println(title1);
        	
        	productPageFlipcart= new ProductPageFlipcart(driver);
        	productPageFlipcart.selectminPrice();
        	productPageFlipcart.selectmaxPrice();
        	Thread.sleep(7000);
        	productPageFlipcart.scrollIntobox();
        	productPageFlipcart.clickHeadPhones();
        	
           }
     
       @Test ( priority=1,dependsOnMethods= {"testToLogin"})
     public void testtoaddproduct() throws InterruptedException {
    	
    	 addToCartHeadPhones=new AddToCartHeadPhones(driver);
    	 Thread.sleep(3000);
    	addToCartHeadPhones.selectaddToCart();
    	
    	removeProduct= new RemoveProduct(driver);
    	removeProduct.clickOnRemoveProduct();
    	removeProduct.clickonremovebutton();
    	
       }
       
       @AfterMethod
         public void afterMethod() throws InterruptedException {
    	homePageFlipcarth.clickToLogout();
    	
          }
    @AfterClass
        public void afterClass() {
        System.out.println("after class");
    	driver.quit();
        }
}
