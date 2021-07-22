package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage extends CommonActions {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href=\"https://www.winwin.rs/customer/account/create/\"]")
    WebElement registerLink;

    public void clickRegisterLink() {
        clickElement(registerLink);
    }

    @FindBy(css = "#firstname")
    WebElement firstNameBar;

    @FindBy(css = "#lastname")
    WebElement lastNameBar;

    @FindBy(css = "#email_address")
    WebElement emailAddressBar;

    @FindBy(css = "#password")
    WebElement passwordBar;

    @FindBy(css = "#confirmation")
    WebElement confirmPasswordBar;

    @FindBy(css = "#advice-validate-password-password")
    WebElement shortPassword;

    public void passTooShort(){
        typeText(firstNameBar, "testname");
        typeText(lastNameBar, "testsurname");
        typeText(emailAddressBar, "emailtest" + System.currentTimeMillis() + "@mail.com");
        typeText(passwordBar, "12");
        typeText(confirmPasswordBar, "12");
        clickElement(submitButtn);

        String errorPasswordText = shortPassword.getText();
        Assert.assertEquals(errorPasswordText, "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @FindBy(css = "[title=\"Pošalji\"]")
    WebElement submitButtn;

    @FindBy(css = ".success-msg")
    WebElement successfulRegistration;

    public void validRegistration() {
        typeText(firstNameBar, "testname");
        typeText(lastNameBar, "testsurname");
        typeText(emailAddressBar, "emailtest" + System.currentTimeMillis() + "@mail.com");
        typeText(passwordBar, "Lozinka123");
        typeText(confirmPasswordBar, "Lozinka123");
        clickElement(submitButtn);

        String successfulRegistrationText = successfulRegistration.getText();
        Assert.assertEquals(successfulRegistrationText,
                "Da biste se ulogovali, potrebno je da potvrdite nalog. Molimo proverite email zbog linka za potvrdu. Ukoliko niste primili email, za ponovno slanje kliknite ovde.");
    }

    @FindBy(css = "#advice-validate-email-email_address")
    WebElement invalidEmailAddress;

    public void invalidEmailAddress() {
        typeText(firstNameBar, "testname");
        typeText(lastNameBar, "testsurname");
        typeText(emailAddressBar, System.currentTimeMillis() + "mail.com");
        typeText(passwordBar, "Lozinka123");
        typeText(confirmPasswordBar, "Lozinka123");
        clickElement(submitButtn);

        String emailErrorText = invalidEmailAddress.getText();
        Assert.assertEquals(emailErrorText, "Molimo unesite ispravnu email adresu. Npr. milanpetrovic@domen.com.");
    }


    @FindBy(css = ".btn.btn-back")
    WebElement backButton;

    public void clickBackButton(){
        clickElement(backButton);
    }


}
