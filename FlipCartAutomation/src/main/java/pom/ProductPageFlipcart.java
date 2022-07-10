package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPageFlipcart {
	@FindBy(xpath="(//select[@class='_2YxCDZ'])[1]")
	private WebElement minPrice;
	
	@FindBy(xpath="(//select[@class='_2YxCDZ'])[2]")
	private WebElement maxPrice;
	
	@FindBy(xpath="//div[@data-id='ACCGARV7CHHVNVH5']")
	private WebElement box;
	
	@FindBy(xpath="//a[text()='Jabra Elite 2 with Rich Bass Bluetooth Headset']")
	private WebElement relemeHeadphone;
	 
	private WebDriver driver;
	  
	    public ProductPageFlipcart(WebDriver driver) 
	    {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	    }
	    
	     public void selectminPrice() throws InterruptedException
	    {Thread.sleep(3000);
		Select s = new Select(minPrice);
		s.selectByValue("2500");
		}
	    public void selectmaxPrice() throws InterruptedException
		{
	    	Thread.sleep(3000);
			Select se = new Select(maxPrice);
		     se.selectByValue("5000");
		}
		
		public void scrollIntobox() throws InterruptedException {
			Thread.sleep(7000);
		    JavascriptExecutor js =(JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",box);
		    
		    }
		public void clickHeadPhones() throws InterruptedException {
			Thread.sleep(5000);
		    relemeHeadphone.click(); 
		    }
		
		
	}

