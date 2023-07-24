package com.solvd.openweather.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PricingPageBase.class)
public class PricingPage extends PricingPageBase{
    @FindBy(xpath = "//h1[text()='Pricing']")
    private ExtendedWebElement pricingTitle;

    public PricingPage(WebDriver driver){
        super(driver);
        setUiLoadedMarker(pricingTitle);
        setPageURL("/examples");
    }
}
