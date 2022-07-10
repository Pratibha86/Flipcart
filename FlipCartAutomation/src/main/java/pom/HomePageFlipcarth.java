package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFlipcarth {

	@FindBy(xpath="//img[@alt='Electronics']")
	private WebElement electronicsDropdown;
	
	@FindBy(xpath="//a[text()='Bluetooth Headphones']")
	private WebElement bluetoothHeadphone;
	
	@FindBy(xpath="(//div[@class='_1psGvi _3BvnxG'])[1]")
	private WebElement anil;
	
	@FindBy(xpath="//div[text()='Logout']")
	private WebElement logout;
	
	private WebDriver driver;
	private Actions action;

	public HomePageFlipcarth(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
		action=new Actions(driver);
		 }
	
	public void SelectElectronicsDropdown() throws InterruptedException {
		Thread.sleep(3000);
		 action.moveToElement(electronicsDropdown).perform();
		}
	
	public void SelectbluetoothHeadphone() throws InterruptedException {
		
		bluetoothHeadphone.click();
	}
	public void clickToLogout() throws InterruptedException {
		Thread.sleep(2000);
		action.moveToElement(anil).perform();
		Thread.sleep(2000);
		logout.click();
	}
	
}
