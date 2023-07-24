package com.solvd.openweather.web;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PartnersPageBase.class)
public class PartnersPage extends PartnersPageBase {
    @FindBy(xpath = "//h1[text()='Partners and solutions']")
    private ExtendedWebElement partnersTitle;

    public PartnersPage(WebDriver driver){
        super(driver);
        setPageURL("/examples");
        setUiLoadedMarker(partnersTitle);
    }

}
