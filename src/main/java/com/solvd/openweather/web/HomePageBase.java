package com.solvd.openweather.web;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
    public abstract APIPageBase openAPIPage();

    public abstract PricingPageBase openPricingPage();

    public abstract GuidePageBase openGuidePage();
    public abstract PartnersPageBase openPartnersPage();

    public abstract LoginPageBase openSignInPage();




}
