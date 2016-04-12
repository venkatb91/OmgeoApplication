package com.omgeo.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OmgeoAlertPage extends OmgeoPageFactory{

	@FindBy(className="HeroHeaderPink")
	WebElement h1SpanElement;
	
	
	public OmgeoAlertPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getH1Text(){
		return h1SpanElement.getText();
	}

}
