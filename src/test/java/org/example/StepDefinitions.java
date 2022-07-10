package org.example;

import POMPages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

     private WebDriver driver;
     private String baseUrl;


     //Constructor tp access the private fields from the Hooks class
    public StepDefinitions(Hooks hooks) {
        this.driver = hooks.driver;
        this.baseUrl = hooks.baseUrl;
    }

    //Background Steps
    @Given("I am on the website's login page")
    public void i_am_on_the_website_s_login_page() throws InterruptedException {

        driver.get("https://www.edgewordstraining.co.uk/demo-site/my-account/");
        Thread.sleep(1000);
    }

    @Given("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) throws InterruptedException {

        loginPOMPage loginPOMPage = new loginPOMPage(driver);
        loginPOMPage.login(username,password);

    }

    @Given("I navigate to the product page")
    public void i_navigate_to_the_product_page() throws InterruptedException {
        shopPOMPage shopPOMPage = new shopPOMPage(driver);
        shopPOMPage.productPage();

    }

    @Given("I add the item to the cart")
    public void i_add_the_item_to_the_cart() throws InterruptedException {

        shopPOMPage shopPOMPage = new shopPOMPage(driver);
        shopPOMPage.addItemToCart();
        Thread.sleep(2000); //on second scenario website misbehaves by not showing all items in the cart - Thread sleep seems to resolve this

    }

    @Given("I go to the cart page")
    public void i_go_to_the_cart_page() {
        cartPOMPage cartPOMPage = new cartPOMPage(driver);
        cartPOMPage.viewCart();

    }

    //Test case 1
    @When("I apply the coupon discount {string}")
    public void i_apply_the_coupon_discount(String couponInput) {
        cartPOMPage cartPOMPage = new cartPOMPage(driver);
        cartPOMPage.addCoupon(couponInput);
        cartPOMPage.checkoutLink();
    }

    @Then("the total amount to be paid is updated correctly")
    public void the_total_amount_to_be_paid_is_updated_correctly() throws InterruptedException {
        checkoutPOMPage checkoutPOMPage = new checkoutPOMPage(driver);
        checkoutPOMPage.result();
        checkoutPOMPage.remove();

        //Log out
        userAccountPOMPage userAccountPOMPage = new userAccountPOMPage(driver);
        userAccountPOMPage.logOut();
    }

    //Test Case 2
    @When("I complete the checkout process")
    public void i_complete_the_checkout_process() throws InterruptedException {

        cartPOMPage cartPOMPage = new cartPOMPage(driver);
        cartPOMPage.checkoutLink();

        checkoutPOMPage checkoutPOMPage = new checkoutPOMPage(driver);
        checkoutPOMPage.placeOrder();

    }

    @Then("the order is saved in the orders page with {string}")
    public void the_order_is_saved_in_the_orders_page_with(String orderNum)  {
        checkoutPOMPage checkoutPOMPage = new checkoutPOMPage(driver);
        checkoutPOMPage.checkMyOrders(orderNum);

    }
}