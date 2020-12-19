package appium.mobileApp.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NineDayForecastPageObject extends BasePageObjects{

    public NineDayForecastPageObject(WebDriver androidDriver){super(androidDriver);}

    public static By nineDayForecastContainerLocator = By.id("mainAppSevenDayView");

    public static By firstDayForecastDateLocator = By.xpath("(//*[@resource-id='hko.MyObservatory_v1_0:id/sevenday_forecast_date'])[1]");

    public static By firstDayForecastTemperatureLocator = By.xpath("(//*[@resource-id='hko.MyObservatory_v1_0:id/sevenday_forecast_temp'])[1]");

    public static By firstDayForecastRhLocator = By.xpath("(//*[@resource-id='hko.MyObservatory_v1_0:id/sevenday_forecast_rh'])[1]");

    public static By firstDayForecastWindLocator = By.xpath("(//*[@resource-id='hko.MyObservatory_v1_0:id/sevenday_forecast_wind'])[1]");

    public static By firstDayForecastDetailsLocator = By.xpath("(//*[@resource-id='hko.MyObservatory_v1_0:id/sevenday_forecast_details'])[1]");

}
