package appium.mobileApp.pom.pageSteps;

import appium.mobileApp.pom.pageObjects.NineDayForecastPageObject;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

public class NineDayForecastPageSteps extends BasePageSteps<NineDayForecastPageObject>{

    public NineDayForecastPageSteps(WebDriver androidDriver, Scenario scn){
        super(androidDriver, scn);
    }

    public void waitNineDayForecastPageToLoad(){
        waitForVisibilityOf(NineDayForecastPageObject.nineDayForecastContainerLocator, "NineDayForecastPageObject.nineDayForecastContainerLocator");
    }

    public void getFirstDayForecastInfo(){
        writeSteps(String.format("Date: (%s) \n Temperature: (%s) \n Relative Humidity: (%s) \n Wind: (%s) \n Details: (%s) ",
        getElementText(NineDayForecastPageObject.firstDayForecastDateLocator),
        getElementText(NineDayForecastPageObject.firstDayForecastTemperatureLocator),
        getElementText(NineDayForecastPageObject.firstDayForecastRhLocator),
        getElementText(NineDayForecastPageObject.firstDayForecastWindLocator),
        getElementText(NineDayForecastPageObject.firstDayForecastDetailsLocator)
        ));
    }
}
