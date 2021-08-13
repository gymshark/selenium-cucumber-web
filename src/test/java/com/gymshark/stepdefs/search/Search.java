package com.gymshark.stepdefs.search;

import com.gymshark.stepdefs.AbstractBaseSteps;

import com.gymshark.pages.checkout.InformationPage;
import com.gymshark.pages.checkout.PaymentPage;
import com.gymshark.pages.checkout.ShippingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.gymshark.pages.minicart.MiniCartPage.getMiniCartPage;
import static com.gymshark.pages.search.SearchPage.getSearchPage;

public class Search extends AbstractBaseSteps {

    private static List<WebElement> searchResults;

    @When("I search for an item I should see a list of matching search results")
    public void theSearchButtonIsClicked() {
        getSearchPage(getWebDriver()).searchForItem("Men's T-Shirt");
        searchResults = getSearchPage(getWebDriver()).getSearchResults();

    }

    @Then("I will choose an item and size which will get added to the cart")
    public void iHoverOverAnItemTheQuickAddSizeCtaWillAppear() {
        getSearchPage(getWebDriver()).moveToProduct(searchResults.get(0));
        getSearchPage(getWebDriver()).selectAvailableSizeViaQuickAdd(0);
        getMiniCartPage(getWebDriver()).assertBagContainsAddedItems(1);
    }

    @When("The cart has opened then I will click on checkout button")
    public void theCartHasOpenedThenIWillClickOnCheckoutButton() {
        getMiniCartPage(getWebDriver()).clickCheckoutBtn();
    }

    @Then("I will be redirected to the information page")
    public void iWillBeRedirectedToTheInformationPage() {
        InformationPage.getInformationPage(getWebDriver()).waitUntilInformationFieldsHaveLoaded();

    }

    @When("I click continue to shipping after filling out the mandatory fields on information")
    public void iClickContinueToShippingAfterFillingOutTheMandatoryFieldsOnInformation() {
        InformationPage.getInformationPage(getWebDriver()).populateContactAndShippingInformationFields();
        InformationPage.getInformationPage(getWebDriver()).clickContinueBtn();
    }

    @Then("I will be taken to the shipping page")
    public void iWillBeTakenToTheShippingPage() {
        ShippingPage.getShippingPage(getWebDriver()).waitUntilVisibilityOfShippingMethod();
    }

    @When("I click on the continue to payment button")
    public void iClickOnTheContinueToPaymentButton() {
        ShippingPage.getShippingPage(getWebDriver()).clickContinueBtn();
    }

    @Then("I will be taken to the payment page")
    public void iWillBeTakenToThePaymentPage() {
        PaymentPage.getPaymentPage(getWebDriver()).assertPaymentBreadCrumbIsActive();
    }

    @When("The minicart is open and i click on the x button")
    public void theMiniCartIsOpenAndIClickOnTheXButton() {
        getMiniCartPage(getWebDriver()).closeMiniCart();
    }

    @Then("The minicart will close")
    public void theMiniCartWillClose() {
        getMiniCartPage(getWebDriver()).waitUntilInvisibilityOfMiniCart();
    }

    @Then("I will add another item which will get added to the cart")
    public void iWillAddAnotherItemWhichWillGetAddedToTheCart() {
        getSearchPage(getWebDriver()).selectAvailableSizeViaQuickAdd(1);
        getMiniCartPage(getWebDriver()).assertBagContainsAddedItems(2);
    }
}
