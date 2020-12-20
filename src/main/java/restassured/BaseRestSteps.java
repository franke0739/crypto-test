package restassured;

import cucumber.api.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.BaseUtil;

public class BaseRestSteps extends BaseUtil{

    protected Response response;
    protected String step, endpoint, body;

    public BaseRestSteps (Scenario scn){
        super(scn);
    }

    private void statusCode(Response response){
        if (response.body().asString().length() > 1000) {
            body = response.body().asString().substring(0, 1000) + "<br/>...please check logs for full payload info";
        } else {
            body = response.body().asString();
        }
        writeSteps(String.format("Response status code: %s<br/>Body: %s", response.statusCode(), body));
    }

    public Response doGetRequest(String endpoint, RequestSpecification request) {
        step = "GET ";
        this.endpoint = endpoint;
        writeSteps(step + endpoint);
        response = request.given().relaxedHTTPSValidation().get(endpoint);
        statusCode(response);
        return response;
    }

    public Response doPostRequest(String endpoint, RequestSpecification request) {
        step = "POST ";
        this.endpoint = endpoint;
        writeSteps(step + endpoint);
        response = request.given().relaxedHTTPSValidation().post(endpoint);
        statusCode(response);
        return response;
    }

    public Response doPutRequest(String endpoint, RequestSpecification request) {
        step = "PUT ";
        this.endpoint = endpoint;
        writeSteps(step + endpoint);
        response = request.given().relaxedHTTPSValidation().put(endpoint);
        statusCode(response);
        return response;
    }

    public Response doDeleteRequest(String endpoint, RequestSpecification request) {
        step = "DELETE ";
        this.endpoint = endpoint;
        writeSteps(step + endpoint);
        response = request.given().relaxedHTTPSValidation().delete(endpoint);
        statusCode(response);
        return response;
    }
}
