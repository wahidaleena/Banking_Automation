package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AboutPage {
	
	private WebDriver driver;
	GeneralUtilities gl=new GeneralUtilities();
	
	public AboutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(tagName = "h1")
	WebElement headingOfPage;
	
	public String getHeadingOfAboutPage() {
		
		return gl.getTextOfElement(headingOfPage);
		
	}
}
