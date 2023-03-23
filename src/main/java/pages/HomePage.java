package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.BaseTest;

public class HomePage extends BaseTest {

    @FindBy(id = "nav-contact")
    WebElement contactButton_id;

    @FindBy(id = "nav-shop")
    WebElement shopButton_id;

    @FindBy(id = "nav-cart")
    WebElement cartButton;

    public void clickOnContactButton() {
        logger.info("Clicking on the contact button");
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(contactButton_id));
        contactButton_id.click();
    }

    public void clickOnShopButton() {
        logger.info("Clicking on the Shop button");
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(shopButton_id));
        shopButton_id.click();
    }

    public HomePage(WebDriver driver) {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCartButton() {
        cartButton.click();
    }
}
