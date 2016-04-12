package com.omgeo.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OmgeoAboutPage extends OmgeoPageFactory{

	@FindBy(tagName="h1")
	WebElement h1Element;
		
	@FindBy(className="chzn-single")
	WebElement selectAnchor;
		
	public OmgeoAboutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getAboutPageH1Text(){
		return h1Element.getText();
	}
	
	public void selectAlertOption(){
		selectAnchor.click();
		List<WebElement>webelements = driver.findElements(By.xpath("//*[@class='chzn-results']/li[2]"));
		webelements.get(0).click();
	}


}
