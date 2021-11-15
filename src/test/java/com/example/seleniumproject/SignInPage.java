package com.example.seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

    WebDriver browser;
    WebDriverWait wait;

    private By signInLinkLocator = By.xpath("//a[contains(.,'Sign In')]");
    private By emailAddressLocator = By.xpath("//label[normalize-space(text())='Email Address']//following-sibling::input");
    private By passwordLocator = By.xpath("//label[normalize-space(text())='Password']//following-sibling::input");
    private By signInButtonLocator = By.xpath("//button[contains(.,'Sign In')]");

    public SignInPage(WebDriver browserDriver) {
        browser = browserDriver;

        wait = new WebDriverWait(browser,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInLinkLocator));
    }

    public void setEmailAddress(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressLocator));
        WebElement emailAddressInput = browser.findElement(emailAddressLocator);
        emailAddressInput.clear();
        emailAddressInput.sendKeys(emailAddress);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        WebElement passwordInput = browser.findElement(passwordLocator);
        passwordInput.sendKeys(password);
    }

    public void clickSignInLink() {
        WebElement signInLink = browser.findElement(signInLinkLocator);
        signInLink.click();
    }

    public void clickSignInButton() {
        WebElement signInLink = browser.findElement(signInButtonLocator);
        signInLink.click();
    }

}