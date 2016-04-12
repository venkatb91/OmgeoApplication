package com.omgeo.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OmgeoLeadershipPage extends OmgeoPageFactory{

	@FindBy(className="HeroHeaderOrange")
	WebElement spanElement;
	
	@FindBy(tagName="table")
	WebElement tableElement;
	
	@FindBy(xpath=".//span[@class='SecondaryCallToAction']//a[contains(text(), 'Learn More +')]")
	List<WebElement> learnMoreElements;
		
	public OmgeoLeadershipPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getHeroHeaderText(){
		return spanElement.getText();
	}
	
	public String getFirstPersonName(){
		List<WebElement> strongs = tableElement.findElements(By.tagName("strong"));		
		return strongs.get(0).getText();
	}

	public String clickLearnMoreLink() {

		learnMoreElements.get(0).click();
		driver.switchTo().frame(0);
		WebElement webelement = driver.switchTo().activeElement();
		WebElement strongElement = webelement.findElement(By.xpath(".//strong"));
		return strongElement.getText();

	}
	
	

}
