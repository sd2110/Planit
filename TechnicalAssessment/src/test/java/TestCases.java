package test.java;

import main.java.pages.CartPage;
import main.java.pages.ContactPage;
import main.java.pages.HomePage;
import main.java.pages.ShopPage;
import org.testng.annotations.Test;

public class TestCases extends BaseTest{


    @Test
    public void verifyAndValidateErrorMessagesOnContactPage() {
        ContactPage contactPage = new ContactPage(driver);
        HomePage homePage = new HomePage(driver) ;
        homePage.clickOnContactButton();
        contactPage.clickOnSubmitButton();
        contactPage.verifyErrors("We welcome your feedback - but we won't get it unless you complete the form correctly.", "Forename is required",
                "Email is required", "Message is required");
        contactPage.enterForename("Sagar");
        contactPage.enterEmail("sd@abc.com");
        contactPage.enterMessage("Hello");
        contactPage.verifyErrorsAreGone();
    }

    @Test(invocationCount = 5)
//    @Test(enabled = false)
    public void verifySuccessfulSubmissionMessage() {
        ContactPage contactPage = new ContactPage(driver);
        HomePage homePage = new HomePage(driver) ;
        homePage.clickOnContactButton();
        contactPage.enterForename("Sagar");
        contactPage.enterEmail("sd@abc.com");
        contactPage.enterMessage("Hello world!");
        contactPage.clickOnSubmitButton();
        contactPage.verifySuccessfulSubmissionMessage("Thanks Sagar, we appreciate your feedback.");
    }

    @Test
    public void verifyPrice_Subtotal_TotalOfProducts() {
        HomePage homePage = new HomePage(driver) ;
        ShopPage shopPage = new ShopPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickOnShopButton();
        shopPage.buyStuffedFrog(2);
        shopPage.buyFluffyBunny(5);
        shopPage.buyValentineBear(3);
        shopPage.getPriceOfStuffedFrog();
        shopPage.getPriceOfFluffyBunny();
        shopPage.getPriceOfValentineBear();
        homePage.clickOnCartButton();
        cartPage.verifySubtotalOfStuffedFrog();
        cartPage.verifySubtotalOfFluffyBunny();
        cartPage.verifySubtotalOfValentineBear();
        cartPage.verifyPriceOfStuffedFrog();
        cartPage.verifyPriceOfFluffyBunny();
        cartPage.verifyPriceOfValentineBear();
        cartPage.verifyTotalOfAllProducts();


    }
}
