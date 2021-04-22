package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final String PAGE_URL = "http://automationpractice.com";

    private static final By CREATE_ACCOUNT_ERROR = By.xpath("//*[@id=\"create_account_error\"]/ol/li");
    private static final By REGISTRATION_ACCOUNT_ERROR = By.xpath("//*[@id=\"center_column\"]/div/ol/li");
    private static final By CONTACT_US_ERROR = By.xpath("//*[@id=\"center_column\"]/div/ol/li");

    private final WebDriver webDriver;

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccount;

    @FindBy(id = "submitAccount")
    private WebElement registerAccount;

    @FindBy(className = "navigation_page")
    private WebElement getNavigationBreadCrumb;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement searchPageAlert;

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(id = "submitMessage")
    private WebElement contactUsSubmitButton;

    @FindBy(className = "heading-counter")
    private WebElement searchPageMessage;

    @FindBy(xpath = "//*[@id=\"newsletter_block_left\"]/div/form/div/button")
    private WebElement newsLetterSubscriptionButton;

    @FindBy(xpath = "//*[@id=\"columns\"]/p")
    private WebElement newsLetterSubscriptionMessage;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getCreateAnAccount() {
        return createAnAccount;
    }

    public WebElement getRegisterAccount() {
        return registerAccount;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getContactUsLink() {
        return contactUsLink;
    }

    public WebElement getSearchPageAlert() {
        return searchPageAlert;
    }

    public WebElement getSearchPageMessage() {
        return searchPageMessage;
    }

    public WebElement getContactUsSubmitButton() {
        return contactUsSubmitButton;
    }

    public WebElement getNavigationBreadCrumb() {
        return getNavigationBreadCrumb;
    }

    private WebElement getNewsLetterSubscriptionButton() {
        return newsLetterSubscriptionButton;
    }

    private WebElement getNewsLetterSubscriptionMessage() {
        return newsLetterSubscriptionMessage;
    }

    public void clickCreateAnAccount() {
        getCreateAnAccount().click();
    }

    public void clickSignInLink() {
        getSignInLink().click();
    }

    public void clickRegistrationAccount() {
        getRegisterAccount().click();
    }

    public void clickSearchButton() {
        getSearchButton().click();
    }

    public String getSearchPageMessageText() {
        return getSearchPageMessage().getText();
    }

    public void clickContactUsLink() {
        getContactUsLink().click();
    }

    public String getSearchPageAlertText() {
        return getSearchPageAlert().getText();
    }

    public void clickContactUsPageSubmitButton() {
        getContactUsSubmitButton().click();
    }

    public String getNavigationBreadCrumbText() {
        return getNavigationBreadCrumb().getText();
    }

    public void clickNewsLetterButton() {
        getNewsLetterSubscriptionButton().click();
    }

    public String getNewsLetterMessage() {
        return getNewsLetterSubscriptionMessage().getText();
    }

    public void fillField(String field, String parameter) {
        webDriver.findElement(By.id(field)).sendKeys(parameter);
    }

    public Optional<String> getCreateAccountErrorMessage() {
        Optional<WebElement> error = getCreateAccountError();
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getCreateAccountError() {
        List<WebElement> errorList = webDriver.findElements(CREATE_ACCOUNT_ERROR);
        if (errorList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(errorList.get(0));
        }
    }

    public Optional<String> getRegistrationAccountErrorMessage() {
        Optional<WebElement> error = getRegistrationAccountError();
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getRegistrationAccountError() {
        List<WebElement> errorList = webDriver.findElements(REGISTRATION_ACCOUNT_ERROR);
        if (errorList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(errorList.get(0));
        }
    }

    public Optional<String> getContactUsErrorMessage() {
        Optional<WebElement> error = getContactUsError();
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getContactUsError() {
        List<WebElement> errorList = webDriver.findElements(CONTACT_US_ERROR);
        if (errorList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(errorList.get(0));
        }
    }


}
