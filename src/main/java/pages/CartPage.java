package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    //locate the cart count
    private By cartCount = By.id("nav-cart-count");
    //locate the cart button that leads to the cart page
    private By cartButton = By.id("nav-cart");
    //locate today's deals button
    private By dealsButton = By.linkText("Today's Deals");
    /*--------------------------------------------------------------------------------------------------*/

    public CartPage (WebDriver driver) {
        this.driver = driver;
    }

    //method to get cart count
    public String getCartCountCartPage (){
        return driver.findElement(cartCount).getText();
    }

    //method to click the cart button (open the same page again)
    public CartPage clickCartButtonCartPage(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public AddedToCartPage backfunction(){
        driver.navigate().back();
        return new AddedToCartPage(driver);
    }

    //method to click today's deals button (open today's deals page)
    public TodayDealsPage clickDealsButtonCartPage(){
        driver.findElement(dealsButton).click();
        return new TodayDealsPage(driver);
    }
}
