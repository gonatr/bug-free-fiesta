package com.selenium.pageObject.GeneralMaster;

import org.example.base.BaseTClass;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class MasterProfilePage extends BaseTClass {
    public static WebDriver driver;

    public MasterProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Mobile User']")
    WebElement clMobileUser;

    public void clickMobileUser() {
        waitElementClickable(clMobileUser);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clMobileUser);
    }

    @FindBy(xpath = "//a[@href='/page/mobile-user/mobile-user-profile']/span[@class='label-text nav-main-link-name']")
    WebElement clMasterProfile;

    public void clickMasterProfile(){
        waitElementClickable(clMasterProfile);
        clMasterProfile.click();
    }

    @FindBy(css = "button[id='new']")
    WebElement clNewButton;

    public void clickNew() throws InterruptedException {
        waitElementClickable(clNewButton);
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", clNewButton);
    }

    @FindBy(xpath = "//a[@id='new-data']")
    WebElement clCreateData;

    public void clickCreateData() {
        waitElementClickable(clCreateData);
        clCreateData.click();
    }

    @FindBy(xpath = "//input[@id='code']")
    WebElement inCode;

    public void setInCode(String text){
        waitForVisibleElement(inCode);
        WebElement a = inCode;
        a.isDisplayed();
        a.click();
        a.clear();
        a.sendKeys(text);
    }

    @FindBy(xpath = "//input[@id='shortname']")
    WebElement inShortName;

    public void setInShortName(String text){
        waitForVisibleElement(inShortName);
        WebElement a = inShortName;
        a.isDisplayed();
        a.click();
        a.clear();
        a.sendKeys(text);
    }

    @FindBy(id = "fullname")
    WebElement inFullName;

    public void setInFullName(String text){
        waitForVisibleElement(inFullName);
        WebElement a = inFullName;
        a.isDisplayed();
        a.click();
        a.clear();
        a.sendKeys(text);
    }

    @FindBy(xpath = "//*[@id='photo']")
    WebElement inPhoto;

    public void setInputPhoto(){
        waitForVisibleElement(inPhoto);
        WebElement a = inPhoto;
        a.sendKeys("C:\\Users\\eska-\\IdeaProjects\\Adele\\src\\main\\java\\org\\example\\file\\redPandas.jpg");
    }

    @FindBy(xpath = "//button[@id='submit']")
    WebElement sbmitButton1;

    public void submitButton() {
        waitElementClickable(sbmitButton1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", sbmitButton1);
    }

    @FindBy(xpath = "//div[@class='swal2-html-container mx-2 fs-sm']")
    WebElement alertAssert;

    public void alertAssertNewData() {
        String message = alertAssert.getText();
        try {
            waitForVisibleElement(alertAssert);
            assertTrue(alertAssert.isDisplayed());
            Assert.assertEquals(message.toString(), "Successfully create data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//button[@class='swal2-confirm btn btn-sm btn-primary me-2'] | //button[@class='swal2-confirm btn btn-sm btn-primary me-2'] | //button[@class='swal2-confirm btn btn-sm btn-primary me-2']")
    WebElement btnConfirm;

    public void btnConfirmAlert() {
        waitForVisibleElement(btnConfirm);
        waitElementClickable(btnConfirm);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", btnConfirm);
    }
}
