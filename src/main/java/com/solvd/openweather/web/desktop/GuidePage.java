package com.solvd.openweather.web.desktop;
import com.solvd.openweather.web.common.GuidePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = GuidePageBase.class)
public class GuidePage extends GuidePageBase{

    @FindBy(xpath = "//h1[text()='Guide']")
    private ExtendedWebElement guideTitle;

    public GuidePage(WebDriver driver){
        super(driver);
        setPageURL("/guide");
        setUiLoadedMarker(guideTitle);
    }
}
