package tests.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.BaseStep;

public class ProductListingSteps extends BaseStep {
    @Before
    public void setup(){
        setupCucumber();
        homePage.fileReader();
    }

    @Given("^I am on \"([^\"]*)\" Home Page$")
    public void iAmOnHomePage(String arg0) throws Throwable {
       homePage.goToHepsiburada(arg0);
    }

    @When("^I enter search input \"([^\"]*)\"$")
    public void iEnterSearchInput(String arg0) throws Throwable {
        homePage.productSearch(arg0);
    }

    @Then("^I should verify the product images are loaded on Listing Page$")
    public void iShouldVerifyTheProductImagesAreLoadedOnListingPage() {
        productListingPage.checkProductImageLoaded();
    }

    @After
    public void close(){ teardown(); }

}
