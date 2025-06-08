package com.vj.store.testcases;

import com.vj.store.base.BaseTest;
import com.vj.store.pages.HomePage;
import com.vj.store.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");

        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.clickStoreMenuLink();
        storePage.enterTextInSearchFld("Blue").clickSearchBtn();
//        storePage.clickSearchBtn();
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        driver.findElement(By.cssSelector(".checkout-button")).click();
        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("John");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Smith");
        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("Flat No 101");
        driver.findElement(By.cssSelector("#billing_city")).sendKeys("NY");
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("94681");
        driver.findElement(By.cssSelector("#billing_email")).sendKeys("John.smith.vj.7jun.2@email.com");
        Thread.sleep(2000);
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(2000);
        Assert.assertEquals(
            driver.findElement(By.cssSelector(".woocommerce-thankyou-order-received")).getText(),
            "Thank you. Your order has been received.");
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");
        driver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
        driver.findElement(By.cssSelector("input#woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(
            driver.findElement(By.cssSelector(".woocommerce-products-header__title")).getText(),
            "Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
        driver.findElement(By.cssSelector(".checkout-button")).click();

        driver.findElement(By.cssSelector("a.showlogin")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#username")).sendKeys("jsmith.vj.123@yopmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("Test123!");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("John");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Smith");
        driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("Flat No 101");
        driver.findElement(By.cssSelector("#billing_city")).sendKeys("NY");
        driver.findElement(By.cssSelector("#billing_postcode")).clear();
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("94681");
        driver.findElement(By.cssSelector("#billing_email")).clear();
        driver.findElement(By.cssSelector("#billing_email")).sendKeys("jsmith.vj.123@yopmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(2000);
        Assert.assertEquals(
            driver.findElement(By.cssSelector(".woocommerce-thankyou-order-received")).getText(),
            "Thank you. Your order has been received.");
    }
}
