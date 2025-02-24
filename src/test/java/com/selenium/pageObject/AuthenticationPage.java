package com.selenium.pageObject;

import org.example.base.BaseTClass;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationPage extends BaseTClass {
    public static WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder='Username']")
    WebElement inUser;

    public void setUsername(String username) {
        waitForVisibleElement(inUser);
        WebElement a = inUser;
        a.isDisplayed();
        a.click();
        a.clear();
        a.sendKeys(username);
    }

    @FindBy(id = "login-password")
    WebElement inPass;

    public void setPassword(String password) {
        waitForVisibleElement(inPass);
        WebElement a = inPass;
        a.isDisplayed();
        a.click();
        a.clear();
        a.sendKeys(password);
    }

    @FindBy(name = "captcha")
    WebElement inCapt;

    public void setInCapt(String password) {
        waitForVisibleElement(inCapt);
        WebElement a = inCapt;
        a.isDisplayed();
        a.click();
        a.clear();
        a.sendKeys(password);
    }

    @FindBy(css = ".btn")
    WebElement btnSubmitLogin;

    public void submitLogin() {
        waitForVisibleElement(btnSubmitLogin);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", btnSubmitLogin);
        btnSubmitLogin.click();
    }

    @FindBy(css = ".btn")
    WebElement btnLogin;

    public void login() {
        waitElementClickable(btnLogin);
        btnLogin.click();
    }

    @FindBy(css = ".p-2")
    WebElement asrtValidDashboard;

    public void assertValidLogin() {
        waitForVisibleElement(asrtValidDashboard);
        assertTrue(asrtValidDashboard.isDisplayed());

    }

    @FindBy(xpath = "//strong[.='These credentials do not match our records.']")
    WebElement asrtInvalid;

    public void assertInvalidLogin() {
        String message = asrtInvalid.getText();
        try {
            assertTrue(asrtInvalid.isDisplayed());
            Assert.assertEquals(message, "These credentials do not match our records.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//div[@class='item item-circle bg-gd-lake-op mx-auto']")
    WebElement accountMenu;

    public void clickAccountMenu() {
        waitElementClickable(accountMenu);
        accountMenu.click();
    }

    @FindBy(xpath = "//a[contains(.,'Sign Out')]")
    WebElement cLsignOut;

    public void clickSignOut() {
        waitElementClickable(cLsignOut);
        cLsignOut.click();
    }

    @FindBy(xpath = "//button[@class='swal2-confirm btn btn-sm btn-primary me-2']")
    WebElement confBtnSignOut;

    public void confirmSignOut() {
        waitElementClickable(confBtnSignOut);
        confBtnSignOut.click();
    }

    @FindBy(xpath = "//p[@class='text-uppercase fw-bold fs-sm text-muted']")
    WebElement asrtSignOut;

    public void assertSignOut() {
        String message = asrtSignOut.getText();
        try {
            waitForVisibleElement(asrtSignOut);
            assertTrue(asrtSignOut.isDisplayed());
            Assert.assertEquals(message, "LOGIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
