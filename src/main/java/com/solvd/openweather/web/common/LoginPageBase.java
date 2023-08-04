package com.solvd.openweather.web.common;
import com.solvd.openweather.web.common.HomePageBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract HomePageBase login();
}
