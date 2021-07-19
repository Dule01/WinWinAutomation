package tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class WinWinTest extends BaseTest{

    @BeforeMethod
    public void setUp(){
        init("CHROME", 15);
    }

    @Test(description = "Verify functionality of Search Bar")
    @Description("Verify that the Search Bar properly functions after entering a text value and clicking the Search Button")
    public void searchBarTest(){
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.clickSearchBar();
        bp.searchWebSite("iPhone");
    }

    @Test(description = "Verify functionality of Search Bar")
    @Description("Verify that the Search Bar properly functions after entering a text value and hitting the Enter " +
            "Button on the keyboard.")
    public void searchBarTestUsingEnter(){
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.clickSearchBar();
        bp.searchWebSiteWithEnterKey("iPhone");
    }

    @AfterMethod
    public void tearDown(){
        quitBrowser();
    }

}
