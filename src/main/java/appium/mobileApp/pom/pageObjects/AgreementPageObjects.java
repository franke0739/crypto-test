package appium.mobileApp.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgreementPageObjects extends BasePageObjects {

    public AgreementPageObjects(WebDriver androidDriver){super(androidDriver);}

    public static By agreeButtonLocator = By.id("btn_agree");

    public static By disagreeButtonLocator = By.id("btn_not_agree");
}
