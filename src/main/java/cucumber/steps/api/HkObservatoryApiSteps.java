package cucumber.steps.api;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.steps.BaseCucumberSteps;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restassured.BaseRestSteps;


public class HkObservatoryApiSteps extends BaseCucumberSteps {
    private Response response;
    private RequestSpecification request;

    @Given("a Hong Kong Observatory API")
    public void hk_observatory_api() {
        testContext().setUrl(testContext().getProperties().getProperty("hk.observatory.api.url"));
    }

    @When("get 9 day weather forecast")
    public void get_9_day_weather_forecast() {
        BaseRestSteps baseRestSteps = new BaseRestSteps(testContext().getScenario());
        request = given().queryParam("dataType", "fnd").queryParam("lang", "en");
        response = baseRestSteps.doGetRequest(testContext().getUrl(), request);
        assertThat(response.statusCode()).as("Verify Status Code").isEqualTo(200);
        testContext().setResponse(response);
    }

    @Then("extract relative humidity for the day after tomorrow")
    public void extract_relative_humidity_for_the_day_after_tomorrow() {
        BaseRestSteps baseRestSteps = new BaseRestSteps(testContext().getScenario());
        response = testContext().getResponse();
        JsonPath jsonPath = response.jsonPath();
        String message = String.format("Relative humidity of the day after tomorrow (%s) is %s - %s%%",
                jsonPath.getString("weatherForecast.week[1]"),
                jsonPath.getString("weatherForecast.forecastMinrh[1].value"),
                jsonPath.getString("weatherForecast.forecastMaxrh[1].value")
        );
        baseRestSteps.writeSteps(message);
    }

}
