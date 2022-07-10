package POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class loginPOMPage {

    WebDriver driver;

    public loginPOMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3), this);
    }

    //Create Locators
    @FindBy (id="username") WebElement username;

    @FindBy (id="password") WebElement password;

    @FindBy (name="login") WebElement loginButton;
    @FindBy (linkText = "Shop") WebElement shopLink;

    //Create Methods

    public void login(String usernameInput, String passwordInput) throws InterruptedException {
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
       Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(1000);
    }

}
