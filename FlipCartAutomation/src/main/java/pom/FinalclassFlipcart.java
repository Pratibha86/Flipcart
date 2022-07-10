package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalclassFlipcart {
	@FindBy(xpath="//button[text()='CONTINUE']")
	private WebElement contionue ;


	public FinalclassFlipcart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void finalContionue () {
		contionue.click();
	}

}
