package appium.mobileApp.pom.pageSteps;

import appium.mobileApp.pom.pageObjects.AgreementPageObject;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

public class AgreementPageSteps extends BasePageSteps<AgreementPageObject> {
    public AgreementPageSteps(WebDriver androidDriver, Scenario scn){ super(androidDriver, scn); }

    public void waitAgreementPageToLoad() {
        waitForVisibilityOf(AgreementPageObject.agreeButtonLocator,"AgreementPageObject.agreeButtonLocator");
        waitForVisibilityOf(AgreementPageObject.disagreeButtonLocator,"AgreementPageObject.disagreeButtonLocator");
    }

    public void clickAgreeButton(){
        click(AgreementPageObject.agreeButtonLocator,"AgreementPageObject.agreeButtonLocator");
    }

}
