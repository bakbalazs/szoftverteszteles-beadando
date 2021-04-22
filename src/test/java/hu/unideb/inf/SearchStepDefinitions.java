package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class SearchStepDefinitions extends StepDefinitions {

    @Given("The search button is clicked")
    public void theSearchButtonIsClicked() {
        homePage.clickSearchButton();
    }

    @Then("Please enter search keyword message is shown")
    public void enterSearchKeywordMessageIsShow() {
        assertEquals("Please enter a search keyword", homePage.getSearchPageAlertText());
    }

    @Given("User entered {string} in {string}")
    public void userEnteredValueInField(String value, String field) {
        homePage.fillField(field, value);
    }

    @Then("The {string} is shown")
    public void theMessageIsShown(String message) {
        assertEquals(message, homePage.getSearchPageMessageText());
    }

}
