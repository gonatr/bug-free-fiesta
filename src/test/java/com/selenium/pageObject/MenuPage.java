package com.selenium.pageObject;

import org.example.base.BaseTClass;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuPage extends BaseTClass {
    public static WebDriver driver;

    public MenuPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#page-header-user-dropdown > .item" )
    WebElement asrtHomePage;

    public void assertHomePage() {
        waitForVisibleElement(asrtHomePage);
        assertTrue(asrtHomePage.isDisplayed());
    }

    //ul[@class='nav-main'] | //ul[contains(.,'MenuHome')]
    @FindBy(xpath = "//ul[@class='nav-main']//a[.='Home'] | //ul[@class='nav-main']//a[.='Home'] | //span[.='Home']")
    WebElement clSidebar;

    public void clickSidebar(){
        waitForVisibleElement(clSidebar);
        Actions a = new Actions(driver);
        a.moveToElement(clSidebar).build().perform();
    }

    @FindBy(xpath = "//span[.='General Master']")
    WebElement clGeneralMaster1;

    public void clickGeneralMaster() {
        waitElementClickable(clGeneralMaster1);
        WebElement b = clGeneralMaster1;
        assertTrue(b.isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", b);
    }

    @FindBy(xpath = "//span[.='Trade-Item Inventory']")
    WebElement clTradde_ItemInventory;

    public void clickTrade_ItemInventory() {
        waitElementClickable(clTradde_ItemInventory);
        WebElement b = clTradde_ItemInventory;
        assertTrue(b.isDisplayed());
        b.click();
    }


    @FindBy(css = "#filter")
    WebElement clFilter;

    public void clickFilter() throws InterruptedException {
        waitForVisibleElement(clFilter);
        waitElementClickable(clFilter);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("arguments[0].click()", clFilter);
    }

    @FindBy(xpath = "//button[@id='execute-data'] | //button[@id='execute-filtered-data'] | //button[@id='btn-execute-filtered-data'] | //button[@class='btn btn-sm btn-primary'] | //button[@id='btn-execute-filtered-data']")
    WebElement clExecuteData;

    public void clickExecuteData() {
        waitElementClickable(clExecuteData);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", clExecuteData);
    }

    @FindBy(xpath = "//td[@class='text-start h6'] | //td[contains(@id,'list')] | //td[contains(@id,'code')] | //tr[@Class='odd my-2']")
    WebElement showData;

    public void assertShowData() {
        waitForVisibleElement(showData);
        Assert.assertTrue(showData.isDisplayed());
    }
}
