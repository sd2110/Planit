package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.BaseTest;
import java.util.List;

public class ContactPage extends BaseTest {

    @FindBy(xpath = "//a[text()='Submit']")
    WebElement submitButton_id;

    @FindBy(id = "header-message")
    WebElement errorHeading_id;

    @FindBy(id = "forename-err")
    List<WebElement> foreNameError_id;

    @FindBy(id = "email-err")
    List<WebElement> emailError_id;

    @FindBy(id = "message-err")
    List<WebElement> messageError_id;

    @FindBy(id = "forename")
    WebElement forenameTextBox_id;

    @FindBy(id = "email")
    WebElement emailTextBox_id;

    @FindBy(id = "message")
    WebElement messageTextBox_id;

    @FindBy(xpath = "//*[@class='alert alert-success']")
    WebElement successMessage_xpath;

    public void clickOnSubmitButton() {
        logger.info("Clicking on the Submit button");
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(submitButton_id));
        submitButton_id.click();
    }
    public void verifyErrors(String expectedErrorHeading, String expectedForenameError, String expectedEmailError, String expectedMessageError) {
        String actualErrorHeading = errorHeading_id.getText();
        String actualForenameError = foreNameError_id.get(0).getText();
        String actualEmailError = emailError_id.get(0).getText();
        String actualMessageError = messageError_id.get(0).getText();

        Assert.assertEquals(actualErrorHeading, expectedErrorHeading, "Heading error is not getting displayed");
        Assert.assertEquals(actualForenameError, expectedForenameError, "Forename error is not getting displayed");
        Assert.assertEquals(actualEmailError, expectedEmailError, "Email error is not getting displayed");
        Assert.assertEquals(actualMessageError, expectedMessageError, "Message text box error is not getting displayed");

        logger.info("The errors for mandatory fields are getting displayed on the screen");
    }

    public void enterForename(String forename) {
        logger.info("Entering the forename");
        forenameTextBox_id.sendKeys(forename);
    }

    public void enterEmail(String email) {
        logger.info("Entering the email");
        emailTextBox_id.sendKeys(email);
    }

    public void enterMessage(String message) {
        logger.info("Entering the message");
        messageTextBox_id.sendKeys(message);
    }

    public void verifyErrorsAreGone() {
        Assert.assertEquals(0, foreNameError_id.size(), "Forename error is still getting displayed");
        Assert.assertEquals(0, emailError_id.size(), "Email error is still getting displayed");
        Assert.assertEquals(0, messageError_id.size(), "Message error is still getting displayed");
        logger.info("The errors are now gone and not getting displayed on the screen");
    }

    public void verifySuccessfulSubmissionMessage(String expectedSuccessMessage) {
        new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(successMessage_xpath));
        String actualSuccessMessage = successMessage_xpath.getText();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message is not getting displayed");
        logger.info("Success message is getting displayed on submission");
    }

    public ContactPage(WebDriver driver) {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
