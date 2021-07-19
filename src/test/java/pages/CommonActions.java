package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class CommonActions {

    WebDriver driver;

    public void clickElement(WebElement element){
        try {
            element.click();
        }catch (StaleElementReferenceException e){
            element.click();
        }
    }

    public void typeText(WebElement element, String textValue){
        element.clear();
        element.sendKeys(textValue);
    }

    public void clickEnter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }

//    public void hover(WebElement element){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).build().perform();
//    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectByText(WebElement element, String textValue){
        Select select = new Select(element);
        select.selectByVisibleText(textValue);
    }

    public void selectByIndex(WebElement element, int i){
        Select select = new Select(element);
        select.selectByIndex(i);
    }

    public void pause(int time) throws InterruptedException {
        Thread.sleep(time * 1000);
    }

}
