package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodayDealsPage {
    private WebDriver driver;

    //locate Headphones checkbox
    private By HeadphonesCheckbox = By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F'][contains(text(),'Headphones')]");

    //locate Grocery checkbox
    private By GroceryCheckbox = By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F'][contains(text(),'Grocery')]");
    //locate "10% off or more" discount
    private By Discount1 = By.xpath("//span[contains(text(),'10% off or more')]");
    //locate the next button in the pages list
    private By NextButton = By.className("a-last");

    //locate any item in the 4th page
    private By Item = By.className("DealGridItem-module__dealItemDisplayGrid_e7RQVFWSOrwXBX4i24Tqg DealGridItem-module__withBorders_2jNNLI6U1oDls7Ten3Dttl DealGridItem-module__withoutActionButton_2OI8DAanWNRCagYDL2iIqN");


    //locate the cart count
    private By cartCount = By.id("nav-cart-count");
    //locate the cart button that leads to the cart page
    private By cartButton = By.id("nav-cart");

    //locate today's deals button
    private By dealsButton = By.linkText("Today's Deals");

    /*--------------------------------------------------------------------------*/
    public TodayDealsPage (WebDriver driver) {
        this.driver = driver;
    }

    //method to check the Headphones checkbox
    public void checkHeadphones(){
        driver.findElement(HeadphonesCheckbox).click();
    }
    //method to check the Grocery checkbox
    public void checkGrocery(){
        driver.findElement(GroceryCheckbox).click();
    }
    //method to click "10% off or more" discount choice
    public void chooseDiscount(){
        driver.findElement(Discount1).click();
    }
    //method to reach the 4th page
    public ItemPage goToFourthPage(){
        for(int i=0; i<3; i++){
            driver.findElement(NextButton).click();
        }
        return new ItemPage(driver);
    }

    //method to select the item (opens item's page)
    public ItemPage selectItem(){
        driver.findElement(Item).click();
        return new ItemPage(driver);
    }

}
