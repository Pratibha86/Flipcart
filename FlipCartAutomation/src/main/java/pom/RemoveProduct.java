package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveProduct {

	@FindBy(xpath="//div[text()='Remove']")
	private WebElement  remove;
	
	@FindBy(xpath="//div[text()='Remove']")
	private WebElement  removebutton;
	
	public RemoveProduct(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	} 
	public void clickOnRemoveProduct() throws InterruptedException {
		Thread.sleep(3000);
		remove.click();
	}
	
	public void clickonremovebutton() throws InterruptedException {
		Thread.sleep(3000);
		removebutton.click();
	}
}
