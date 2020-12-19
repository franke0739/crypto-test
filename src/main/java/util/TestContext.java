package util;

import static java.lang.ThreadLocal.withInitial;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public enum TestContext {
    CONTEXT;
    private static final String URL = "URL";
    private static final String RESPONSE = "RESPONSE";
    private static final String REQUEST = "REQUEST";
    private static final String SCENARIO = "SCENARIO";
    private static final String PROPERTIES = "PROPERTIES";
    private static final String ANDROIDDRIVER = "ANDROIDDRIVER";
    private final ThreadLocal<Map<String, Object>> testContexts = withInitial(HashMap::new);

    public <T> T get(String name) {
        return (T) testContexts.get().get(name);
    }

    public <T> T set(String name, T object) {
        testContexts.get().put(name, object);
        return object;
    }

    public RequestSpecification getRequest() {
        if (null == get(REQUEST)) {
            set(REQUEST, given().log()
                    .all());
        }
        return get(REQUEST);
    }

    public Scenario setScenario(Scenario scn){ return set(SCENARIO, scn);}

    public Scenario getScenario(){ return get(SCENARIO);}

    public Properties setProperties(Properties pro){ return set(PROPERTIES, pro);}

    public Properties getProperties(){ return get(PROPERTIES);}

    public RequestSpecification setRequest(RequestSpecification request){ return set(REQUEST, request);}

    public Response getResponse() {
        return get(RESPONSE);
    }

    public Response setResponse(Response response) {
        return set(RESPONSE, response);
    }

    public AppiumDriver setAndroidDriver(AppiumDriver driver) {
        return set(ANDROIDDRIVER, driver);
    }

    public AppiumDriver getAndroidDriver(){ return get(ANDROIDDRIVER); }

    public String setUrl(String url){
        return set(URL, url);
    }

    public String getUrl(){
        return get(URL);
    }

    public void reset() {
        testContexts.get()
                .clear();
    }
}
