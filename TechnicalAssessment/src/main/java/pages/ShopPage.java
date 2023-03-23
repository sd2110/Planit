package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.BaseTest;

public class ShopPage extends BaseTest{
    public static float priceOfStuffedFrogInShop;
    public static float priceOfFluffyBunnyInShop;
    public static float priceOfValentineBearInShop;


    @FindBy(xpath = "//*[@id='product-2']/div/p/a[text()='Buy']")
    WebElement buyStuffedFrogButton;

    @FindBy(xpath = "//*[@id='product-4']/div/p/a[text()='Buy']")
    WebElement buyFluffyBunnyButton;

    @FindBy(xpath = "//*[@id='product-7']/div/p/a[text()='Buy']")
    WebElement buyValentineBearButton;

    @FindBy(xpath = "//*[@id='product-2']/div/p/span[@class='product-price ng-binding']")
    WebElement priceOfStuffedFrog;

    @FindBy(xpath = "//*[@id='product-4']/div/p/span[@class='product-price ng-binding']")
    WebElement priceOfFluffyBunny;

    @FindBy(xpath = "//*[@id='product-7']/div/p/span[@class='product-price ng-binding']")
    WebElement priceOfValentineBear;


    public void buyStuffedFrog(int quantity) {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(buyStuffedFrogButton));
        for (int i=0; i<quantity; i++) {
            buyStuffedFrogButton.click();
        }
        logger.info("Buying stuffed frogs");
    }

    public void buyFluffyBunny(int quantity) {
        for (int i=0; i<quantity; i++) {
            buyFluffyBunnyButton.click();
        }
        logger.info("Buying fluffy bunnies");
    }

    public void buyValentineBear(int quantity) {
        for (int i=0; i<quantity; i++) {
            buyValentineBearButton.click();
        }
        logger.info("Buying valentine bears");
    }
    
    public void getPriceOfStuffedFrog() {
        priceOfStuffedFrogInShop = Float.parseFloat(priceOfStuffedFrog.getText().replace("$", ""));
    }

    public void getPriceOfFluffyBunny() {
        priceOfFluffyBunnyInShop = Float.parseFloat(priceOfFluffyBunny.getText().replace("$",""));
    }

    public void getPriceOfValentineBear() {
        priceOfValentineBearInShop = Float.parseFloat(priceOfValentineBear.getText().replace("$",""));
    }



    public ShopPage(WebDriver driver) {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
