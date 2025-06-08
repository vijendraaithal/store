package com.vj.store.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void startDriver() {
        driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
