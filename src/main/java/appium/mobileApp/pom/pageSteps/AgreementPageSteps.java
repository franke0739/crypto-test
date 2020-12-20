package appium.mobileApp.pom.pageSteps;

import appium.mobileApp.pom.pageObjects.AgreementPageObjects;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

public class AgreementPageSteps extends BasePageSteps<AgreementPageObjects> {
    public AgreementPageSteps(WebDriver androidDriver, Scenario scn){ super(androidDriver, scn); }

    public void waitAgreementPageToLoad() {
        waitForVisibilityOf(AgreementPageObjects.agreeButtonLocator,"AgreementPageObjects.agreeButtonLocator");
        waitForVisibilityOf(AgreementPageObjects.disagreeButtonLocator,"AgreementPageObjects.disagreeButtonLocator");
    }

    public void clickAgreeButton(){
        click(AgreementPageObjects.agreeButtonLocator,"AgreementPageObjects.agreeButtonLocator");
    }

}
