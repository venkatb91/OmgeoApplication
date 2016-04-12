package com.omgeo.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.omgeo.pagefactory.OmgeoAboutPage;
import com.omgeo.pagefactory.OmgeoAlertPage;
import com.omgeo.pagefactory.OmgeoHomePage;
import com.omgeo.pagefactory.OmgeoLeadershipPage;

public class OmgeoTest {

	private WebDriver driver = new FirefoxDriver();
	private OmgeoHomePage homePage = new OmgeoHomePage(driver);;
	private OmgeoAboutPage aboutPage = new OmgeoAboutPage(driver);
	private OmgeoAlertPage alertPage = new OmgeoAlertPage(driver);
	private OmgeoLeadershipPage leadershipPage = new OmgeoLeadershipPage(driver);

	@BeforeTest
	public void setup() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void testHomePageAppearCorrect() {
		driver.get("http://www.omgeo.com");
		Assert.assertTrue(homePage.getWhoWeAreAnchorText().equals("Who We Are"));
	}

	@Test(priority = 1)
	public void testAboutPageAppearCorrect() {
		homePage.clickAboutLink();
		Assert.assertTrue(aboutPage.getAboutPageH1Text().equals("What We Bring to the Table"));
	}

	@Test(priority = 2)
	public void testAlertPageAppearCorrect() {
		aboutPage.selectAlertOption();
		Assert.assertTrue(alertPage.getH1Text().equals("Omgeo ALERT"));
	}

	@Test(priority = 3)
	public void testLeaderShipPage() {
		homePage.hoverAboutSelectLeaderShip();
		Assert.assertTrue(leadershipPage.getHeroHeaderText().equals("Committed to propelling the industry forward"));
	}

	@Test(priority = 4)
	public void testMemberClick() {
		Assert.assertEquals(leadershipPage.getFirstPersonName(), leadershipPage.clickLearnMoreLink());
	}

}
