package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ProductsPage;

public class WinWinTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
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

    @Test(description = "Verify the functionality of top links")
    @Description("Verify that all of the 3 links at the top of the page properly work")
    public void topLinksFunctionality(){
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.clickWhereToBuyTop();
        bp.clickPaymentMethodsTop();
        bp.clickCommonQuestionsTop();
    }

    @Test(description = "Header Hover Tests")
    @Description("Verify that all of the buttons can be properly hovered with correct display afterwards.")
    public void headerHoverTests() throws InterruptedException {
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.pause(1);
        bp.hoverMyAcc();
        bp.pause(1);
        bp.hoverMyBasket();
        bp.pause(1);
        bp.hoverProducts();
        bp.pause(1);
    }

    @Test(description = "Verify Help Box Links")
    @Description("Verify that all of the 3 help box links are clickable and functional.")
    public void helpBoxTest() throws InterruptedException {
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.clickBusinessBenefits();
        bp.clickTaxFree();
        bp.clickFeedback();
        bp.pause(2);
    }

    @Test(description = "Newsletter with an invalid email address")
    @Description("Verify that proper error text is displayed if an incorrect email address is entered")
    public void newsletterTest(){
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.newsletterInvalidEmail("123");
    }

    @Test(description = "Newsletter with a valid email address")
    @Description("Verify that proper error text is displayed if a correct email address is entered")
    public void newsletterTest2(){
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.newsletterValidEmail("testemail12901@mail.com");
    }

    @Test(description = "Verify functionality of footer links")
    @Description("Verify that footer links are clickable and lead to intended web page")
    public void footerLinks() {
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.footerBasePageLinks("Gde kupiti");
        bp.footerBasePageLinks("Rokovi isporuke");
        bp.footerBasePageLinks("Kontakti ovlašćenih servisa ");
    }

    @Test(description = "Social Links Functionality")
    @Description("Veirfy that all of the social link buttons are clickable and functional")
    public void socialLinks() throws InterruptedException {
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.clickFacebookBtn();
        bp.clickInstagramBtn();
        bp.clickTwitterBtn();
        bp.clickYouTubeBtn();
        bp.clickWinWinBlogBtn();
        bp.pause(3);
    }

    @Test(description = "Verify Phone Numbers")
    @Description("Verify that at least one of 3 contact numbers appears")
    public void phoneNumbersTest() throws InterruptedException {
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.verifyPhoneNumbers();
    }

    @Test(description = "Product filtering by price")
    @Description("Verify that proper product are listed after selecting them and filtering them by price")
    public void searchProducts() throws InterruptedException {
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.hoverProducts();
        ProductsPage pp = new ProductsPage(driver);
        pp.pause(1);
        pp.selectProdCategoryAndType("Laptop i tablet računari", "Laptopovi");
        pp.pause(1);
        pp.filterProdByMinimumPrice("50000.00");

        for(int i = 0; i < pp.productTypeName.size(); i++){
            Assert.assertTrue(pp.productTypeName.get(i).getText().contains("Laptop") || pp.productTypeName.get(i).getText().contains("laptop"));
        }
    }

    @Test(description = "Verify that Compare buttons properly function")
    @Description("Verify that the random compare button properly works and that the appropriate text appears after " +
            "clicking it")
    public void verifyCompareText() throws InterruptedException {
        driver.get("https://www.winwin.rs/");
        BasePage bp = new BasePage(driver);
        bp.declinePushNotifications();
        bp.hoverProducts();
        ProductsPage pp = new ProductsPage(driver);
        pp.pause(1);
        pp.selectProdCategoryAndType("Laptop i tablet računari", "Laptopovi");
        pp.clickRandomCompareButton();
    }

    @AfterMethod
    public void tearDown() {
        quitBrowser();
    }

}
