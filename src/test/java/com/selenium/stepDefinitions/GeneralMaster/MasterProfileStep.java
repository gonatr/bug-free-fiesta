package com.selenium.stepDefinitions.GeneralMaster;

import com.selenium.pageObject.GeneralMaster.MasterProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.base.BaseTClass;
import org.example.utils.Hooks;
import org.openqa.selenium.WebDriver;

public class MasterProfileStep {
    private final WebDriver driver;

    public MasterProfileStep() {
        this.driver = Hooks.driver;
    }

    MasterProfilePage masterProfile;
    @And("User click Mobile User, select Master Profile")
    public void userClickMobileUserSelectMasterProfile() {
        masterProfile = new MasterProfilePage(driver);
        masterProfile.clickMobileUser();
        masterProfile.clickMasterProfile();
    }

    @And("User click New at Master Profile")
    public void userClickNewAtMasterProfile() throws InterruptedException {
        masterProfile.clickNew();
        masterProfile.clickCreateData();
    }

    @And("User input {string} values Master Profile")
    public void userInputValuesMasterProfile(String text) {
        if (text.toLowerCase().contains("code")) {
            masterProfile.setInCode(BaseTClass.generateCode());
        } else if (text.toLowerCase().contains("shortname")) {
            masterProfile.setInShortName(BaseTClass.generateName());
        } else if (text.toLowerCase().contains("fullname")) {
            masterProfile.setInFullName(BaseTClass.generateFullName());
        } else if (text.toLowerCase().contains("photo")) {
            masterProfile.setInputPhoto();
        } else {
            System.out.println("Error: " + text);
        }
    }

    @And("User click Submit Master Profile")
    public void userClickSubmitMasterProfile() {
        masterProfile.submitButton();
    }

    @Then("User get Result from New Data Master Profile")
    public void userGetResultFromNewDataMasterProfile() {
        masterProfile.alertAssertNewData();
        masterProfile.btnConfirmAlert();
    }
}
