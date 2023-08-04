package com.solvd.openweather.web.desktop;

import com.solvd.openweather.web.common.APIPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = APIPageBase.class)
public class APIPage extends APIPageBase{

    @FindBy(xpath = "//h1[text()='Weather API']")
    private ExtendedWebElement weatherAPITitle;

    public APIPage(WebDriver driver){
        super(driver);
        setUiLoadedMarker(weatherAPITitle);
        setPageURL("/api");

    }
}
