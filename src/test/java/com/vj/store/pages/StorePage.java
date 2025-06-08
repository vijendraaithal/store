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

    public StorePage enterTextInSearchFld(String text) {
        driver.findElement(searchFld).sendKeys(text);
        return this;
    }

    public StorePage clickSearchBtn() {
        driver.findElement(searchBtn).click();
        return this;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void clickAddToCartBtn() {
        driver.findElement(addToCartBtn).click();
    }

    public StorePage search(String text) {
        enterTextInSearchFld(text);
        clickSearchBtn();
        return this;
    }

}
