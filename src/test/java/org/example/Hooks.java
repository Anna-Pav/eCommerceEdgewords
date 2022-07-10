package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Hooks {


    WebDriver driver;
    String baseUrl = "https://www.edgewordstraining.co.uk/demo-site/";


    @Before //setting up the driver before each scenario
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @After//Closing the driver after every scenario
    public void tearDown(){
       // driver.quit();
    }
}
