package com.solvd.openweather.web;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//li[@class='user-li']/a")
    private ExtendedWebElement signInTopMenu;

    @FindBy(name = "commit")
    private ExtendedWebElement submitButton;

    @FindBy(id = "user_email")
    private ExtendedWebElement emailTextBox;

    @FindBy(id = "user_password")
    private ExtendedWebElement passwordTextBox;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/users/sign_in");
        setUiLoadedMarker(signInTopMenu);
    }
    @Override
    public HomePageBase login(){
        emailTextBox.type(R.TESTDATA.get("user_email"));
        passwordTextBox.type(R.TESTDATA.get("user_password"));
        submitButton.click();
        return initPage(driver, HomePageBase.class);
    }
}
