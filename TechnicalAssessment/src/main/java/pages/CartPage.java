package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.BaseTest;

import java.text.DecimalFormat;

public class CartPage extends BaseTest{
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @FindBy(xpath = "//tbody/tr[1]/td[2][@class='ng-binding']")
    WebElement priceOfStuffedFrogInCart;

    @FindBy(xpath = "//tbody/tr[2]/td[2][@class='ng-binding']")
    WebElement priceOfFluffyBunnyInCart;

    @FindBy(xpath = "//tbody/tr[3]/td[2][@class='ng-binding']")
    WebElement priceOfValentineBearInCart;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/input[@name='quantity']")
    WebElement quantityOfStuffedFrogInCart;

    @FindBy(xpath = "//tbody/tr[2]/td[3]/input[@name='quantity']")
    WebElement quantityOfFluffyBunnyInCart;

    @FindBy(xpath = "//tbody/tr[3]/td[3]/input[@name='quantity']")
    WebElement quantityOfValentineBearInCart;

    @FindBy(xpath = "//tbody/tr[1]/td[4][@class='ng-binding']")
    WebElement subtotalOfStuffedFrog;

    @FindBy(xpath = "//tbody/tr[2]/td[4][@class='ng-binding']")
    WebElement subtotalOfFluffyBunny;

    @FindBy(xpath = "//tbody/tr[3]/td[4][@class='ng-binding']")
    WebElement subtotalOfValentineBear;

    @FindBy(xpath = "//strong[@class='total ng-binding']")
    WebElement totalPriceInCart;

    public void verifySubtotalOfStuffedFrog() {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(subtotalOfStuffedFrog));
        float actualSubtotalOfStuffedFrog = Float.parseFloat(subtotalOfStuffedFrog.getText().replace("$",""));
        float expectedSubtotalOfStuffedFrog = ShopPage.priceOfStuffedFrogInShop*Integer.parseInt(quantityOfStuffedFrogInCart.getAttribute("Value"));
        Assert.assertEquals(actualSubtotalOfStuffedFrog, expectedSubtotalOfStuffedFrog);
        logger.info("Subtotal of stuffed frog is correctly displayed");
    }

    public void verifySubtotalOfFluffyBunny() {
        float actualSubtotalOfFluffyBunny = Float.parseFloat(subtotalOfFluffyBunny.getText().replace("$",""));
        float expectedSubtotalOfFluffyBunny = Float.parseFloat(df.format(ShopPage.priceOfFluffyBunnyInShop *Integer.parseInt(quantityOfFluffyBunnyInCart.getAttribute("Value"))));
        Assert.assertEquals(actualSubtotalOfFluffyBunny, expectedSubtotalOfFluffyBunny);
        logger.info("Subtotal of fluffy bunny is correctly displayed");
    }

    public void verifySubtotalOfValentineBear() {
        float actualSubtotalOfValentineBear = Float.parseFloat(subtotalOfValentineBear.getText().replace("$",""));
        double expectedSubtotalOfValentineBear = ShopPage.priceOfValentineBearInShop *Integer.parseInt(quantityOfValentineBearInCart.getAttribute("Value"));
        Assert.assertEquals(actualSubtotalOfValentineBear, expectedSubtotalOfValentineBear);
        logger.info("Subtotal of valentine bear is correctly displayed");
    }
    
    public void verifyPriceOfStuffedFrog() {
        float actualPriceOfStuffedFrog = Float.parseFloat(priceOfStuffedFrogInCart.getText().replace("$",""));
        Assert.assertEquals(actualPriceOfStuffedFrog, ShopPage.priceOfStuffedFrogInShop);
        logger.info("Price of stuffed frog is displayed correctly on the cart page");
    }

    public void verifyPriceOfFluffyBunny() {
        float actualPriceOfFluffyBunny = Float.parseFloat(priceOfFluffyBunnyInCart.getText().replace("$",""));
        Assert.assertEquals(actualPriceOfFluffyBunny, ShopPage.priceOfFluffyBunnyInShop);
        logger.info("Price of fluffy bunny is displayed correctly on the cart page");
    }
    public void verifyPriceOfValentineBear() {
        float actualPriceOfValentineBear = Float.parseFloat(priceOfValentineBearInCart.getText().replace("$",""));
        Assert.assertEquals(actualPriceOfValentineBear, ShopPage.priceOfValentineBearInShop);
        logger.info("Price of valentine bear is displayed correctly on the cart page");
    }

    public void verifyTotalOfAllProducts() {
        Float actualTotal = Float.parseFloat(totalPriceInCart.getText().replace("Total: ",""));
        Float expectedTotal = Float.parseFloat(subtotalOfStuffedFrog.getText().replace("$","")) +
                Float.parseFloat(subtotalOfFluffyBunny.getText().replace("$","")) +
                Float.parseFloat(subtotalOfValentineBear.getText().replace("$",""));
        Assert.assertEquals(actualTotal, expectedTotal);
        logger.info("Total of all products is displayed correctly on the cart page");
    }
    

    public CartPage(WebDriver driver) {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
