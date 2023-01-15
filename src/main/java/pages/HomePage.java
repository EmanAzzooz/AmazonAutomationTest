package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    //locate the search text box
    private By searchBox = By.id("twotabsearchtextbox");
    //locate the search button
    private By searchButton = By.id("nav-search-submit-button");
    //locate the cart count
    private By cartCount = By.id("nav-cart-count");
    //locate the cart button that leads to the cart page
    private By cartButton = By.id("nav-cart");
    //locate today's deals button
    private By dealsButton = By.xpath("//a[@data-csa-c-slot-id='nav_cs_5']");
    //private By dealsButton = By.linkText("Today's Deals");

    /*-------------------------------------------------------------------------------------------*/

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //method to enter the input in the search box
    public void setSearchBox (String keyword){
        driver.findElement(searchBox).sendKeys(keyword);
    }

    //method to click search button (it remains at the home page but changes the content)
    public SearchResultPage clickSearchButton (){
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }

    //method to get cart count
    public int getCartCountHomePage (){
        return Integer.parseInt(driver.findElement(cartCount).getText());
    }

    //method to click the cart button (open cart's page)
    public CartPage clickCartButtonHomePage(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    //method to click today's deals button (open today's deals page)
    public TodayDealsPage clickDealsButtonHomePage(){
        driver.findElement(dealsButton).click();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return new TodayDealsPage(driver);
    }
}
