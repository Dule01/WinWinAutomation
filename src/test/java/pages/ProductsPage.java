package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends CommonActions{
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProdCategoryAndType(String productCategory, String productType){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@class=\"nav-primary\"]//li//span[text()=\""+productCategory+"\"]"))).build().perform();
        clickElement(driver.findElement(By.xpath("//*[@class=\"nav-primary\"]//li//span[text()=\""
                +productCategory+"\"]/../..//span[text()=\""+productType+"\"]")));
    }


}
