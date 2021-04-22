package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ContactUsStepDefinitions extends StepDefinitions {

    @And("User clicks on the contact us button")
    public void clickContactUsButton() {
        homePage.clickContactUsLink();
    }

    @Given("User enters valid email address")
    public void userEntersValidEmailAddress() {
        homePage.fillField("email", "test@email.com");
    }

    @And("User clicks on the Send button")
    public void userClicksOnTheSendButton() {
        homePage.clickContactUsPageSubmitButton();
    }

    @Then("The message cannot be blank error message is shown")
    public void theMessageCannotBeBlankErrorMessageIsShown() {
        Optional<String> errorMessage = homePage.getContactUsErrorMessage();
        if (errorMessage.isPresent()) {
            Assert.assertEquals("The message cannot be blank.", errorMessage.get());
        } else {
            Assert.fail();
        }
    }

    @Given("User enters invalid email address")
    public void userEntersInvalidEmailAddress() {
        homePage.fillField("email", "test.email.com");
    }

    @Then("Invalid email address error message is shown")
    public void invalidEmailAddressErrorMessageIsShown() {
        Optional<String> errorMessage = homePage.getContactUsErrorMessage();
        if (errorMessage.isPresent()) {
            Assert.assertEquals("Invalid email address.", errorMessage.get());
        } else {
            Assert.fail();
        }
    }

    @And("User enters message")
    public void userEntersMessage() {
        homePage.fillField("message", "Teszt Üzenet");
    }

    @And("User selects a subject")
    public void userSelectsASubject() {
        Select subjectDropdown = new Select(driver.findElement(By.id("id_contact")));
        subjectDropdown.selectByIndex(1);
    }

    @Then("Your message has been successfully sent to our team message is shown")
    public void yourMessageHasBeenSuccessfullySentToOurTeamMessageIsShown() {
        assertEquals("Your message has been successfully sent to our team.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());
    }

}
