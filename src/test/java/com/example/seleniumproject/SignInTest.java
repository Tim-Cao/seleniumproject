package com.example.seleniumproject;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInTest {

    WebDriver browser;
    WebDriverWait wait;

    private By userAvatar = By.xpath("//span[contains(@class,'sticker-user-icon')]");
    private By signInButtonLocator = By.xpath("//button[contains(.,'Sign In')]");

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://localhost:8080");
    }

    @AfterEach
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void login() {
        SignInPage signInPage = new SignInPage(browser);
        signInPage.clickSignInLink();
        signInPage.setEmailAddress("test@liferay.com");
        signInPage.setPassword("test");
        signInPage.clickSignInButton();

        wait = new WebDriverWait(browser,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(signInButtonLocator));

        WebElement userAvatarIcon = browser.findElement(userAvatar);
        userAvatarIcon.isDisplayed();
    }

}