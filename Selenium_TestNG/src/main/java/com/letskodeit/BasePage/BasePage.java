package com.letskodeit.BasePage;

import org.openqa.selenium.WebDriver;

public class BasePage extends com.letskodeit.base.CustomDriver {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean verifyTitle(String expectedTitle) {
        return getTitle().equalsIgnoreCase(expectedTitle);
    }
}
