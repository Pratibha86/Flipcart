package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderFlipcart {
	@FindBy(xpath="(//button[@class='_23FHuj'])[2]")
	private WebElement addQuantity;

	@FindBy(xpath="//span[text()='Place Order']")
	private WebElement placeOrder;



	public PlaceOrderFlipcart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void placeOrderHeadPhones(WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",addQuantity);
		addQuantity.click();
		
		placeOrder.click();
	}
}
