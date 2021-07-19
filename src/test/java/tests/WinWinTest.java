package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

public class WinWinTest extends BaseTest{

    @BeforeMethod
    public void setUp(){
        init("CHROME", 15);
    }

    @Test
    public void basePageTest() throws InterruptedException {
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.clickActions();
        bp.pause(3);
    }

    @AfterMethod
    public void tearDown(){
        quitBrowser();
    }

}
