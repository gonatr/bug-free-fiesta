package com.selenium.stepDefinitions;

import com.selenium.pageObject.MenuPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.utils.Hooks;
import org.openqa.selenium.WebDriver;

public class MenuStep {
    private final WebDriver driver;

    public MenuStep() {
        this.driver = Hooks.driver;
    }

    MenuPage menuPage;
    @When("User on Dashboard, click General Master on side left Menu")
    public void userOnDashboardClickGeneralMasterOnSideLeftMenu() throws InterruptedException {
        menuPage = new MenuPage(driver);
        menuPage.assertHomePage();
        menuPage.clickSidebar();
        Thread.sleep(3000);
        menuPage.clickGeneralMaster();
    }

    @And("User click Filter")
    public void userClickFilter() throws InterruptedException {
        Thread.sleep(1000);
        menuPage.clickFilter();
    }

    @And("User click Execute Data")
    public void userClickExecuteData() throws InterruptedException {
        menuPage.clickExecuteData();
        Thread.sleep(3000);
    }

    @Then("User get results from Execute Filter Data")
    public void userGetResultsFromExecuteFilterData() {
        menuPage.assertShowData();
    }
}
