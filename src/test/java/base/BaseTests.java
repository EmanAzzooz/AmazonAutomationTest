package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.time.Duration;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //set the browser resolution of 1024x768px
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.get("https://www.amazon.com/");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void closeUp(){
        driver.quit();
    }

}
