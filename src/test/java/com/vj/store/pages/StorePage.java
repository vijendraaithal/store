package com.vj.store.pages;

import com.vj.store.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {
    private final By searchFld = By.cssSelector("input#woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title");
    private final By addToCartBtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextInSearchFld(String text) {
        driver.findElement(searchFld).sendKeys(text);
    }

    public void clickSearchBtn() {
        driver.findElement(searchBtn).click();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void clickAddToCartBtn() {
        driver.findElement(addToCartBtn).click();
    }

}

/*
driver.findElement(By.cssSelector("input#woocommerce-product-search-field-0")).sendKeys("Blue");
driver.findElement(By.cssSelector("button[value='Search']")).click();
 */
