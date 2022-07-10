package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkoutPOMPage {

    WebDriver driver;

    public checkoutPOMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3), this);
    }

    //Create Locators

    @FindBy (xpath = "/html/body/div/div[2]/div/div[1]/main/article/div/div/form[2]/div[2]/table/tfoot/tr[1]/td/span") WebElement subtotal;
    @FindBy (className = "remove") WebElement removeButton;
    @FindBy (linkText = "Cart") WebElement cartLink;
    @FindBy (xpath = "/html/body/div/div[2]/div/div[1]/main/article/div/div/form[2]/div[2]/table/tfoot/tr[4]/td/strong/span") WebElement total;
    @FindBy (id="place_order") WebElement orderButton;
    @FindBy (linkText = "My account") WebElement userAccountLink;
    @FindBy (linkText = "Orders") WebElement myOrders;
    @FindBy (xpath = "/html/body/div/div[2]/div/div[1]/main/article/div/div/div/ul/li[1]") WebElement orderNumber;

    @FindBy (className = "woocommerce-orders-table__row") WebElement orderTable;

//Create Methods

    public void result(){

       float discount = (float) 0.15;
       float shipping = (float) 3.95;


       String subText = subtotal.getText();
       String totalText = total.getText();

       //removing the characters from the strings that hold the prices
        String str1 = subText.replaceAll("[^\\d.]", "");
        String str2 = totalText.replaceAll("[^\\d.]", "");

        //turning the new split strings into floats
        float parsedSubtotal = Float.parseFloat(str1);
        float parsedTotal = Float.parseFloat(str2);
        float result = parsedSubtotal - (parsedSubtotal*discount) + shipping; //calculating the final result

        //assertion to test the final result is as expected
        assertEquals(result, parsedTotal);

    }

    //Method to remove the items from the cart after the test
    public void remove() throws InterruptedException {
        cartLink.click();
        List<WebElement> listofItems = driver.findElements(By.className("woocommerce-cart-form__cart-item"));
        if(listofItems.size()>0) {
            for (int i = listofItems.size(); i>0; i--) {
                removeButton.click();
                Thread.sleep(2000); //to avoid stale element error
            }
        }
    }

    public void placeOrder() throws InterruptedException {

        Thread.sleep(2000);
        orderButton.click();
        String orderNum = orderNumber.getText();
        //passing the order number as argument to the method in order to gain access to it and use it in the next step
        checkMyOrders(orderNum);
    }

    public void checkMyOrders(String orderNum){

        userAccountLink.click();
        myOrders.click();
        //check if the orders table contains the order number
        boolean result = orderTable.getText().contains(orderNum);
        System.out.println(result);
    }

}
