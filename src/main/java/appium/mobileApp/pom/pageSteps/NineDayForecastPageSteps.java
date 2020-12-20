package appium.mobileApp.pom.pageSteps;

import appium.mobileApp.pom.pageObjects.NineDayForecastPageObjects;
import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

public class NineDayForecastPageSteps extends BasePageSteps<NineDayForecastPageObjects>{

    public NineDayForecastPageSteps(WebDriver androidDriver, Scenario scn){
        super(androidDriver, scn);
    }

    public void waitNineDayForecastPageToLoad(){
        waitForVisibilityOf(NineDayForecastPageObjects.nineDayForecastContainerLocator, "NineDayForecastPageObjects.nineDayForecastContainerLocator");
    }

    public void getFirstDayForecastInfo(){
        writeSteps(String.format("Date: (%s) \n Temperature: (%s) \n Relative Humidity: (%s) \n Wind: (%s) \n Details: (%s) ",
        getElementText(NineDayForecastPageObjects.firstDayForecastDateLocator),
        getElementText(NineDayForecastPageObjects.firstDayForecastTemperatureLocator),
        getElementText(NineDayForecastPageObjects.firstDayForecastRhLocator),
        getElementText(NineDayForecastPageObjects.firstDayForecastWindLocator),
        getElementText(NineDayForecastPageObjects.firstDayForecastDetailsLocator)
        ));
    }
}
