package com.solvd.openweather;
import com.solvd.openweather.web.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.report.testrail.TestRailCases;
import org.testng.annotations.Test;

@MethodOwner(owner = "nataliasirt")
public class WebTest implements IAbstractTest {
    @TestRailCases(testCasesId = "8")
    @Test(testName = "API Page", description = "Checks the ability to go to API page from home page")
    public void testAPIMenuNavigatesToAPIPage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();
        homePage.pause(10);
        APIPageBase apiPageBase = homePage.openAPIPage();
        apiPageBase.assertPageOpened();

    }
    @TestRailCases(testCasesId = "9")
    @Test(testName = "Pricing Page", description = "Checks the ability to go to Pricing page from home page")
    public void testPricingMenuNavigatesToPricingPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();
        homePage.pause(10);
        PricingPageBase pricingPageBase = homePage.openPricingPage();
        pricingPageBase.assertPageOpened();
    }

    @TestRailCases(testCasesId = "10")
    @Test(testName = "Guide Page", description = "Checks the ability to go to Guide page from home page")
    public void testGuideMenuNavigatesToGuidePage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();
        homePage.pause(10);
        GuidePageBase guidePageBase = homePage.openGuidePage();
        guidePageBase.assertPageOpened();
    }

    @TestRailCases(testCasesId = "11")
    @Test(testName = "Partners Page", description = "Checks the ability to go to Partners page from home page")
    public void testPartnersMenuNavigatesToPartnersPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();
        homePage.pause(10);
        PartnersPageBase partnersPageBase = homePage.openPartnersPage();
        partnersPageBase.assertPageOpened();
    }
    @TestRailCases(testCasesId = "12")
    @Test(testName = "Test Login" , description = "Test the ability to login to a web page.")
    public void testLoginPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();
        homePage.pause(10);
        LoginPageBase loginPageBase = homePage.openSignInPage();
        loginPageBase.assertPageOpened();
        loginPageBase.pause(10);
        loginPageBase.login();
        loginPageBase.pause(5);
    }
}
