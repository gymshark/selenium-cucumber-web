package com.gymshark.stepdefs;

import io.cucumber.java.en.Given;

public class CommonSteps extends AbstractBaseSteps {

    @Given("The Gymshark homepage has successfully loaded")
    public void theGymsharkHomepageHasSuccessfullyLoaded() {
        getWebDriver().get(getTestEndpoint());
        closeCookies();
    }
}
