package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class cartPOMPage {

    WebDriver driver;

    public cartPOMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3), this);
    }

    //Create Locators

    @FindBy (className = "added_to_cart") WebElement viewCartButton;
    @FindBy (id = "coupon_code") WebElement couponInput;
    @FindBy (name = "apply_coupon") WebElement couponButton;
    @FindBy (className = "checkout-button") WebElement checkoutButton;



//Create Methods

    public void viewCart(){
        viewCartButton.click();
    }

    public void addCoupon(String coupon){
        couponInput.sendKeys(coupon);
        couponButton.click();

    }

    public void checkoutLink(){
        checkoutButton.click();
    }


}
