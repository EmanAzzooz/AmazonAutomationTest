package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
    private WebDriver driver;

    //locate add to cart button
    private By addToCartButton = By.id("add-to-cart-button");

    //locate the cart count
    private By cartCount = By.id("nav-cart-count");
    //locate the cart button that leads to the cart page
    private By cartButton = By.id("nav-cart");
    //locate today's deals button
    private By dealsButton = By.linkText("Today's Deals");

    //what's in the page that identifies each item? something like item id //

    /*-------------------------------------------------------------------------------------------*/

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    //method to click add to cart button
    public AddedToCartPage addItemToCart (){
        driver.findElement(addToCartButton).click();
        return new AddedToCartPage(driver);
    }

    //method to get cart count
    public int getCartCountItemPage (){
        return Integer.parseInt(driver.findElement(cartCount).getText());
    }

    //method to click the cart button (open cart's page)
    public CartPage clickCartButtonItemPage(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    //method to click today's deals button (open today's deals page)
    public TodayDealsPage clickDealsButtonItemPage(){
        driver.findElement(dealsButton).click();
        return new TodayDealsPage(driver);
    }

}
