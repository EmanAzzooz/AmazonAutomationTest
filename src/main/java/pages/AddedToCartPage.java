package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddedToCartPage {
    private WebDriver driver;

    //locate the cart count
    private By cartCount = By.id("nav-cart-count");
    //locate the cart button that leads to the cart page
    private By cartButton = By.id("nav-cart");

    //locate "Added to Cart" text
    private By AddedToCartText = By.cssSelector("span[class*='sw-atc-text']");
    //locate "Go to Cart" button
    private By GoToCartButton = By.xpath("//a[@href='/gp/cart/view.html?ref_=sw_gtc']");

    //locate today's deals button
    private By dealsButton = By.linkText("Today's Deals");

    /*--------------------------------------------------------------------------------------------------*/

    public AddedToCartPage (WebDriver driver) {
        this.driver = driver;
    }

    //method to get cart count
    public String getCartCountAddedToCartPage (){
        return driver.findElement(cartCount).getText();
    }

    //method to click the cart button (open the same page again)
    public CartPage clickCartButtonAddedToCartPage(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    //method to get the text message in the page
    public String getTextMsg(){
        return driver.findElement(AddedToCartText).getText();
    }

    //method to click "Go to Cart" button (go to Cart Page)
    public CartPage clickGoToCartButton(){
        driver.findElement(GoToCartButton).click();
        return new CartPage(driver);
    }

    //method to click today's deals button (open today's deals page)
    public TodayDealsPage clickDealsButtonAddedToCartPage(){
        driver.findElement(dealsButton).click();
        return new TodayDealsPage(driver);
    }
}
