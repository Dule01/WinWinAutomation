package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WinWinTest extends BaseTest{

    @BeforeMethod
    public void setUp(){
        init("CHROME", 15);
    }

    @Test
    public void openWebsite(){
        driver.get("https://www.winwin.rs/");
    }

    @AfterMethod
    public void tearDown(){
        quitBrowser();
    }

}
