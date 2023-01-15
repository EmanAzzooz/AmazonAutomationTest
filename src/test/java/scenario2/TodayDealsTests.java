package scenario2;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TodayDealsTests extends BaseTests {

    @Test
    public void test2(){
        TodayDealsPage todayDealsPage = homePage.clickDealsButtonHomePage();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        todayDealsPage.checkGrocery();
        todayDealsPage.checkHeadphones();
        todayDealsPage.chooseDiscount();
        todayDealsPage.goToFourthPage();
        ItemPage itemPage = todayDealsPage.selectItem();
        AddedToCartPage addedToCartPage = itemPage.addItemToCart();
        Assert.assertEquals(addedToCartPage.getTextMsg(), "Added to Cart", "Error Msg");

    }
    //Compare the Item name in Item's page and Cart Page--> should be the same

}
