package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage extends CommonActions{

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".seg-popup-push .seg-popup-push-bttn-later-new")
    WebElement pushNotificationsLater;

    public void declinePushNotifications(){
        try{
            clickElement(pushNotificationsLater);
        }catch (Exception e){
            System.out.println("Push Notifications pop-up didn't show up.");
        }
    }

    @FindBy(css = "#search")
    WebElement searchBar;

    @FindBy(css = "[title=\"Pretraga\"]")
    WebElement searchButton;

    public void clickSearchBar(){
        clickElement(searchBar);
    }

    public void searchWebSite(String searchValue){
        typeText(searchBar, searchValue);
        clickElement(searchButton);
    }

    public void searchWebSiteWithEnterKey(String searchValue){
        typeText(searchBar, searchValue);
        clickEnter(searchBar);
    }

    @FindBy(css = ".skip-action.account-button")
    WebElement myAccount;

    public void hoverMyAcc(){
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccount).build().perform();
    }

    @FindBy(css = ".cart-link.skip-btn")
    WebElement myBasket;

    public void hoverMyBasket(){
        Actions actions = new Actions(driver);
        actions.moveToElement(myBasket).build().perform();
    }

    @FindBy(css = "#newsletter")
    WebElement newsletterBar;

    @FindBy(css = "[title=\"Prijavite se\"]")
    WebElement newsletterSignUp;

    @FindBy(css = ".validation-advice")
    WebElement validationText;

    public void newsletterInvalidEmail(String invalidEmail){                 //invalid email = anything without '@' e.g.
        clickElement(newsletterBar);
        typeText(newsletterBar, invalidEmail);
        clickElement(newsletterSignUp);
        String errorText = validationText.getText();
        Assert.assertEquals(errorText, "Molimo unesite ispravnu email adresu. Npr. milanpetrovic@domen.com.");
    }

    @FindBy(css = ".i.i-benefit")
    WebElement businessBenefits;

    public void clickBusinessBenefits(){
        clickElement(businessBenefits);
    }

    @FindBy(css = ".i.i-taxfree")
    WebElement taxFree;

    public void clickTaxFree(){
        clickElement(taxFree);
    }

    @FindBy(css = ".i.i-criticism")
    WebElement feedback;

    public void clickFeedback(){
        clickElement(feedback);
    }

    @FindBy(css = ".top-links [title=\"Gde kupiti\"]")
    WebElement whereToByeTopLink;

    public void clickWhereToBuyTop(){
        clickElement(whereToByeTopLink);
    }

    @FindBy(css = ".top-links [title=\"Načini plaćanja\"]")
    WebElement paymentMethodsTopLink;

    public void clickPaymentMethodsTop(){
        clickElement(paymentMethodsTopLink);
    }

    @FindBy(css = ".top-links [title=\" Najčešća pitanja\"]")
    WebElement commonQuestionsTopLink;

    public void clickCommonQuestionsTop(){
        clickElement(commonQuestionsTopLink);
    }

    @FindBy(css = "#menu .menu-item.catalog.overlay-effect")
    WebElement productsTop;

    public void hoverProducts(){
        Actions actions = new Actions(driver);
        actions.moveToElement(productsTop).build().perform();
    }

    @FindBy(css = "#menu .menu-item.action-item [href=\"https://www.winwin.rs/filters/product/action/\"]")
    WebElement actionsMenu;

    public void clickActions(){
        clickElement(actionsMenu);
    }

    @FindBy(css = ".new-catalog")
    WebElement newCatalog;

    public void clickNewCatalog(){
        clickElement(newCatalog);
    }

    @FindBy(css = ".phone-scroll")
    WebElement phoneNumAnimation;

    public void verifyPhoneNumbers(){
        String expectedNumbers;
        String phoneNum = phoneNumAnimation.getText();
        //TODO Assertation
    }

    public void footerBasePageLinks(String linkName){
        clickElement(driver.findElement(By.cssSelector("#container1-footer [title=\""+linkName+"\"]")));
        //Footer links available:
        //O nama, Gde kupiti, Zaposlenje, Blog, Kako kupiti ONLINE, Najčešća pitanja, Načini plaćanja,
        //Obaveštenje o pravima potrošača, Rokovi isporuke, Pravni subjekti, Garancije / Reklamacije
        //Kontakti ovlašćenih servisa
        //Copy and paste one of them as the 'linkName' parameter without spaces and commas in the WinWinTest class
    }

    @FindBy(css = ".i.i-facebook")
    WebElement facebookBtn;

    public void clickFacebookBtn(){
        clickElement(facebookBtn);
    }

    @FindBy(css = ".i.i-instagram")
    WebElement instagramBtn;

    public void clickInstagramBtn(){
        clickElement(instagramBtn);
    }

    @FindBy(css = ".i.i-twitter")
    WebElement twitterBtn;

    public void clickTwitterBtn(){
        clickElement(twitterBtn);
    }

    @FindBy(css = ".i.i-youtube")
    WebElement youTubeBtn;

    public void clickYouTubeBtn(){
        clickElement(youTubeBtn);
    }

    @FindBy(css = ".i.i-wlogo")
    WebElement winWinBlogBtn;

    public void clickWinWinBlogBtn(){
        clickElement(winWinBlogBtn);
    }

    @FindBy(css = ".logo")
    WebElement homeLogoBtn;

    public void clickHomeLogo(){
        clickElement(homeLogoBtn);
    }

















































}
