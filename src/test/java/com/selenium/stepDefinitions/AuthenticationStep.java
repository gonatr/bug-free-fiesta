package com.selenium.stepDefinitions;

import com.selenium.pageObject.AuthenticationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.base.BaseTClass;
import org.example.utils.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AuthenticationStep {
    public static WebDriver driver;

    public AuthenticationStep() {
        this.driver = Hooks.driver;
    }
    AuthenticationPage authenticationPage;
    @Given("User on home Page ERP system")
    public void userOnHomePageERPSystem() {
        authenticationPage = new AuthenticationPage(driver);
    }

    @When("User input username {string}, the password {string} and clicks on the login button")
    public void userInputUsernameThePasswordAndClicksOnTheLoginButton(String user, String pass) {
        authenticationPage.setUsername(user);
        authenticationPage.setPassword(pass);
//        authPage.setInCapt(user);
        authenticationPage.login();
        BaseTClass.pageLoaded();
        authenticationPage.assertValidLogin();
    }

    @Then("Get result login resource")
    public void getResultLoginResource() throws InterruptedException {
        String url = driver.getCurrentUrl();
        if (url.contains("http://192.168.88.139:8000/")) {
            Thread.sleep(1000);
            authenticationPage.assertValidLogin();
            Assert.assertTrue(url.contains("http://192.168.88.139:8000/"));
        } else if (url.contains("login")) {
            authenticationPage.assertInvalidLogin();
        }
    }
}
