package pom;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCartHeadPhones {
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement addtocart;
	
	WebDriver driver;
	public AddToCartHeadPhones(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void selectaddToCart() {
		
		ArrayList<String> add = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		addtocart.click();
	}

}
