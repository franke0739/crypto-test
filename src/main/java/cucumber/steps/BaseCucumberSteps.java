package cucumber.steps;

import util.TestContext;

import static util.TestContext.CONTEXT;

public abstract class BaseCucumberSteps {
    public static TestContext testContext() {
        return CONTEXT;
    }
}
