package scenario1;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddedToCartPage;
import pages.CartPage;
import pages.ItemPage;
import pages.SearchResultPage;

public class SearchAndSelectTests extends BaseTests {
    //test searching for car accessories, selecting the first item, and adding it to cart successfully

    //Future Work: Splite the common part into a function that runs before the remaining part of each scenario
    //**There is Dublication**//


    @Test
    //test for the MSG "Added to Cart" in AddedToCart Page
    public void testAddedMsg(){
        homePage.setSearchBox("car accessories");
        SearchResultPage searchResultPage = homePage.clickSearchButton();
        ItemPage itemPage = searchResultPage.selectFirstItem();
        AddedToCartPage addedToCartPage = itemPage.addItemToCart();
        Assert.assertEquals(addedToCartPage.getTextMsg(), "Added to Cart", "Error Msg");
    }

    @Test
    //test cart count changes at AddedToCart Page
    public void testCartCountCurrentPage(){
        homePage.setSearchBox("car accessories");
        SearchResultPage searchResultPage = homePage.clickSearchButton();
        ItemPage itemPage = searchResultPage.selectFirstItem();
        AddedToCartPage addedToCartPage = itemPage.addItemToCart();
        Assert.assertEquals(addedToCartPage.getCartCountAddedToCartPage(), "1", "Error Msg");
    }

    @Test
    //test cart count changes at Cart Page
    public void testSearchAddToCart(){
        homePage.setSearchBox("car accessories");
        SearchResultPage searchResultPage = homePage.clickSearchButton();
        ItemPage itemPage = searchResultPage.selectFirstItem();
        AddedToCartPage addedToCartPage = itemPage.addItemToCart();
        CartPage cartPage = addedToCartPage.clickGoToCartButton();
        Assert.assertEquals(cartPage.getCartCountCartPage(), "1", "Error Msg");
    }

    //test that the count remains the same when we press back
    @Test
    public void testSearchAddToCartBack(){
        homePage.setSearchBox("car accessories");
        SearchResultPage searchResultPage = homePage.clickSearchButton();
        ItemPage itemPage = searchResultPage.selectFirstItem();
        AddedToCartPage addedToCartPage = itemPage.addItemToCart();
        CartPage cartPage = addedToCartPage.clickGoToCartButton();
        AddedToCartPage addedToCartPage1 = cartPage.backfunction();
        Assert.assertEquals(addedToCartPage1.getCartCountAddedToCartPage(), "1", "Error Msg");

    }

    //**To Do**//
    //Test if we add the same item twice--> check cart count and the quantity of the element in Cart page
    //Test cart count when we go back to Home page
    //Test deleting the item and go back to previous page--> expected that "Added to Cart" shouldn't appear
    //Compare the Item name in Item's page and Cart Page--> should be the same

}
