package com.solvd.openweather.web.desktop;
import com.solvd.openweather.web.common.*;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase{

    @FindBy(xpath = "//li[@class='user-li']/a")
    private ExtendedWebElement signInTopMenu;
    @FindBy(xpath = "//a[@href='/guide']")
    private ExtendedWebElement guideTopMenu;

    @FindBy(xpath = "//a[@href=\"/api\"]")
    private ExtendedWebElement apiTopMenu;

    @FindBy(xpath = "//a[@href='/price']")
    private ExtendedWebElement pricingTopMenu;

    @FindBy(xpath = "//a[@href='/weathermap']")
    private ExtendedWebElement mapsTopMenu;

    @FindBy(xpath = "//a[@href='/examples']")
    private ExtendedWebElement partnersTopMenu;

    @FindBy(xpath = "//a[@href='/weather-dashboard']")
    private ExtendedWebElement dashboardTopMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    @Override
    public APIPageBase openAPIPage(){
        apiTopMenu.click();
        return initPage(driver, APIPageBase.class);
    }

    @Override
    public PricingPageBase openPricingPage(){
        pricingTopMenu.click();
        return initPage(driver, PricingPageBase.class);

    }
    @Override
    public GuidePageBase openGuidePage(){
        guideTopMenu.click();
        return initPage(driver, GuidePageBase.class);
    }

    @Override
    public PartnersPageBase openPartnersPage(){
        partnersTopMenu.click();
        return initPage(driver, PartnersPageBase.class);
    }

    @Override
    public LoginPageBase openSignInPage(){
        signInTopMenu.click();
        return initPage(driver, LoginPageBase.class);
    }

    }
