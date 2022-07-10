package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFlipcart {
	
@FindBy(xpath="(//input[@type='text'])[2]")
private WebElement mobileId;

@FindBy(xpath="//input[@type='password']")
private WebElement passwordId;

@FindBy(xpath="(//button[@type='submit'])[2]")
private WebElement loginButton;

public LoginPageFlipcart(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void sendMobileId(String user) {
	mobileId.click();
	mobileId.sendKeys(user);
	
      }
    public void sendPasswordId(String pass) {
	passwordId.click();
	passwordId.sendKeys(pass);
	
        }
    public void clickOnLogin() {
	loginButton.click();
       }
    
 }
