package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    private WebDriver driver;
    //locate the first item in the search result
    private By firstResult = By.cssSelector("div[cel_widget_id*='MAIN-SEARCH_RESULT']");
    //locate the cart count
    private By cartCount = By.id("nav-cart-count");
    //locate the cart button that leads to the cart page
    private By cartButton = By.id("nav-cart");

    //locate today's deals button
    private By dealsButton = By.linkText("Today's Deals");
    /*----------------------------------------------------------------------------------------*/
    //constructor
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    //method to select the first item (open item's page)
    public ItemPage selectFirstItem (){
        driver.findElement(firstResult).click();
        return new ItemPage(driver);
    }

    //method to get cart count
    public String getCartCountResultsPage (){
        return driver.findElement(cartCount).getText();
    }

    //method to click the cart button (open cart's page)
    public CartPage clickCartButtonResultsPage(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    //method to click today's deals button (open today's deals page)
    public TodayDealsPage clickDealsButtonResultPage(){
        driver.findElement(dealsButton).click();
        return new TodayDealsPage(driver);
    }
}
