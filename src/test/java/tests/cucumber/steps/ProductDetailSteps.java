package tests.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.BaseStep;

public class ProductDetailSteps extends BaseStep {
    @When("^I click on any product$")
    public void iClickOnAnyProduct() throws Exception {
        productListingPage.clickRandomProduct();
    }

    @Then("^I should see Product Detail Page$")
    public void iShouldSeeProductDetailPage() throws Exception {
        productDetailPage.verifyProductDetailPage();
    }

    @When("^I click reviews tab$")
    public void iClickReviewsTab() {
        productDetailPage.clickToReviewsTab();
    }

    @And("^I click yes like icon$")
    public void iClickYesLikeIcon() {
        productDetailPage.likeToReview();
    }

    @Then("^I should see thanks text$")
    public void iShouldSeeThanksText() {
    }
}
