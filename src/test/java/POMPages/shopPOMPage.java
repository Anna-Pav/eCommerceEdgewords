package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class shopPOMPage {

    WebDriver driver;

    public shopPOMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3), this);
    }

    //Create Locators

    @FindBy (linkText = "Shop") WebElement shopLink;
   // @FindBy (xpath = "//main[@id='main']/ul//a[@href='?add-to-cart=27']") WebElement addToCart1;
    //@FindBy (xpath = "//main[@id='main']/ul//a[@href='?add-to-cart=29']") WebElement addToCart2;
    //@FindBy (xpath = "//main[@id='main']/ul//a[@href='?add-to-cart=30']") WebElement addToCart3;
    @FindBy (css = "a[data-product_id='27']") WebElement addItem;
    @FindBy (css = "a[data-product_id='29']") WebElement addItem2;
    @FindBy (css = "a[data-product_id='30']") WebElement addItem3;
    @FindBy (linkText = "Dismiss") WebElement dismissLink;

//Create Methods


    public void productPage() throws InterruptedException {
        shopLink.click();
        Thread.sleep(1000);
    }

    public void addItemToCart(){
        dismissLink.click();
        addItem.click();
        addItem2.click();
        addItem3.click();
    }


}
