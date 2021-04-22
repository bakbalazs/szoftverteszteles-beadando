package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class RegistrationStepDefinitions extends StepDefinitions {
    static List<RegistrationField> registrationFields;

    public RegistrationStepDefinitions() {
        registrationFields = new ArrayList<>();
        registrationFields.add(new RegistrationField("customer_firstname", "Test firstname"));
        registrationFields.add(new RegistrationField("customer_lastname", "Test lastname"));
        registrationFields.add(new RegistrationField("passwd", "abc123"));
        registrationFields.add(new RegistrationField("address1", "Test address"));
        registrationFields.add(new RegistrationField("city", "Test city"));
        registrationFields.add(new RegistrationField("postcode", "00000"));
        registrationFields.add(new RegistrationField("phone_mobile", "06201234123"));
        registrationFields.add(new RegistrationField("id_state", "1", true));
    }

    @And("The Sign in link is clicked")
    public void theSignInLinkIsClicked() {
        homePage.clickSignInLink();
    }

    @Given("Create account is clicked")
    public void createAccountIsClicked() {
        homePage.clickCreateAnAccount();
    }

    @Then("an Invalid email address error message is show")
    public void invalidEmailAddressErrorMessageIsShow() {
        Optional<String> errorMessage = homePage.getCreateAccountErrorMessage();
        if (errorMessage.isPresent()) {
            Assert.assertEquals("Invalid email address.", errorMessage.get());
        } else {
            Assert.fail();
        }
    }

    @Given("The email address field is field a valid email")
    public void theEmailAddressFieldIsFieldWithRandomValidEmail() {
        homePage.fillField("email_create", UUID.randomUUID() + "@test.com");
    }

    @When("I click Create an account")
    public void clickCreateAnAccount() {
        homePage.clickCreateAnAccount();
    }

    @And("I leave empty this {string}")
    public void leaveEmptyThisField(String field) {
        for (RegistrationField registrationField : registrationFields) {
            if (registrationField.equals(new RegistrationField(field, ""))) {
                continue;
            }
            if (!registrationField.isSelect()) {
                homePage.fillField(registrationField.getId(), registrationField.getValue());
            } else {
                Select tmp = new Select(driver.findElement(By.id(registrationField.getId())));
                tmp.selectByValue(registrationField.getValue());
            }
        }
    }

    @And("I click on the register button")
    public void clickOnRegistrationButton() {
        homePage.clickRegistrationAccount();
    }

    @Then("I get {string} error message")
    public void getMessageError(String message) {
        Optional<String> errorMessage = homePage.getRegistrationAccountErrorMessage();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(message, errorMessage.get());
        } else {
            Assert.fail();
        }
    }

    @And("User enters valid data")
    public void userEnterValidRegistrationData() {
        for (RegistrationField registrationField : registrationFields) {
            if (!registrationField.isSelect()) {
                driver.findElement(By.id(registrationField.getId())).sendKeys(registrationField.getValue());
            } else {
                Select tmp = new Select(driver.findElement(By.id(registrationField.getId())));
                tmp.selectByValue(registrationField.getValue());
            }
        }
    }

    @Then("An account is created, user is redirected to My account page")
    public void accountCreatedSuccessfully() {
        assertTrue(homePage.getNavigationBreadCrumbText().contains("My account"));
    }
}
