package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class userAccountPOMPage {

    WebDriver driver;

    public userAccountPOMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3), this);
    }

    //Create Locators
    @FindBy (linkText = "My account") WebElement userAccountLink;
    @FindBy (linkText = "Log out") WebElement logoutLink;


//Create Methods

    public void logOut(){
        userAccountLink.click();
        logoutLink.click();
    }



}
