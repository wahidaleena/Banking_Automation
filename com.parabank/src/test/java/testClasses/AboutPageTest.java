package testClasses;

import org.testng.annotations.Test;

import org.testng.Assert;


import base.BaseClass;
import pageClasses.AboutPage;
import pageClasses.LandingPage;
import utilities.Constants;

public class AboutPageTest extends BaseClass {
	
	LandingPage land;
	AboutPage about;
	
	
  @Test(priority = 0,description="To verify if correct page is loaded when clicked on About Us")
  public void verifyTheCorrectPageIsLoaded() {
	  
	  land=new LandingPage(getDriver());
	  about=land.clickOnAboutUs();
	  String actualText=about.getHeadingOfAboutPage();
	  String expectedText=Constants.headingOfAboutUs;
	  System.out.println("Actual heading: "+actualText);
	  Assert.assertTrue(actualText.contains(expectedText),"Incorrect Heading");
  }
}
