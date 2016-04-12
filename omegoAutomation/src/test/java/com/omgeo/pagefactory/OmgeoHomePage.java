package com.omgeo.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OmgeoHomePage extends OmgeoPageFactory{

	@FindBy(className = "selected")
	WebElement whoWeAreAnchor;

	@FindBy(linkText = "About")
	WebElement aboutLink;

	public OmgeoHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getWhoWeAreAnchorText() {
		return whoWeAreAnchor.getText();
	}
	
	public void clickAboutLink() {
		aboutLink.click();
	}
	
	public void hoverAboutSelectLeaderShip(){
		Actions mousehover = new Actions(driver);
		mousehover.moveToElement(aboutLink);
		WebElement leaderShipLink = driver.findElement(By.linkText("Leadership Team"));
		leaderShipLink.click();
	}
	
}
