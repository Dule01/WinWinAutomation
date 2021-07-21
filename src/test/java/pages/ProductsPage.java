package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

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

    public void filterProdByMinimumPrice(String minimumPriceValue){
        clickElement(driver.findElement(By.cssSelector(".filter-wrapper .filter-item--label [content=\""+minimumPriceValue+"\"]")));
    }

    @FindBy(css = ".col-main .category-products .item")
    public List<WebElement> productTypeName;

    @FindBy(css = ".products-grid .item .add-to-links .link-compare")
    public List<WebElement> compareButtons;

    @FindBy(css = ".success-msg")
    WebElement compareSuccessMsg;



    public void clickRandomCompareButton(){
        Random randomCompareBtn = new Random();
        int randomNum = randomCompareBtn.nextInt(compareButtons.size());
        clickElement(compareButtons.get(randomNum));
        System.out.println("Clicked " + randomNum);                        //showing in console that every time test is being run a new index of button is clicked

        String compareSuccessText = compareSuccessMsg.getText();
        Assert.assertTrue(compareSuccessText.contains("je dodat na listu za poređenje."));
    }




}
