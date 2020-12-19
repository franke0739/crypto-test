package appium.mobileApp.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObjects{

    public BasePageObjects(WebDriver androidDriver) {
        PageFactory.initElements(androidDriver, this);
    }

}
