package org.example.base;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTClass {
    private static WebDriver driver;

    public BaseTClass(WebDriver driver) {
        BaseTClass.driver = driver;
    }

    public void scrollTo() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void scrollToHorizontal() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(700,0)");
    }
    public void scrollToVertical() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(40,3000)");
    }

    public static void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitForVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void pageLoaded() {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
    }

    public static String generateLorem() {
        Faker faker = new Faker();
        return faker.lorem().paragraph(5);
    }

    public static String generateSentence() {
        Faker faker = new Faker();
        return faker.lorem().sentence(1);
    }

    public static String generateShortSentence() {
        Faker faker = new Faker();
        return faker.lorem().sentence(1);
    }

    public static String generateCharacter10() {
        Faker faker = new Faker();
        return faker.lorem().characters(10);
    }

    public static String generateDescription() {
        Faker faker = new Faker();
        return faker.lorem().sentence(2);
    }

    public static String generateCharacter() {
        Faker faker = new Faker();
        return faker.lorem().characters(15);
    }

    public static String generateCharacter45() {
        Faker faker = new Faker();
        return faker.lorem().characters(45);
    }

    public static String generateAccountNumber() {
        Faker faker = new Faker();
        return faker.bothify("??#?#??##??##??");
    }

    public static String generateCode() {
        Faker faker = new Faker();
        return faker.bothify("??.??/##-??_Test");
    }

    public static String generateUsername() {
        Faker faker = new Faker();
        return faker.bothify("raka");
    }

    public static String generatePassword() {
        Faker faker = new Faker();
        return faker.bothify("R@ka123!");
    }

    public static String generateSymbol() {
        Faker faker = new Faker();
        return faker.bothify("!@#$%^&*()");
    }

    public static String generateAlisName() {
        Faker faker = new Faker();
        return faker.bothify("????-##??");
    }

    public static String generateCurrencyCode() {
        Faker faker = new Faker();
        return faker.currency().code();
    }

    public static String generateName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateFullName() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }

    public static String generateAddress() {
        Faker faker = new Faker();
        return faker.address().fullAddress();
    }

    public static String generateDate() {
        Faker faker = new Faker();
        return faker.bothify("0#0#2023");
    }

    public static String generateNewDate() {
//        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        Faker faker = new Faker();
        return faker.bothify("##0#2024");
    }

    public static String generateZipCode() {
        Faker faker = new Faker();
        return faker.address().zipCode();
    }

    public static String generateInitial() {
        Faker faker = new Faker();
        return faker.bothify("???##");
    }

    public static String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generateValue() {
        Faker faker = new Faker();
        return faker.bothify("########");
    }

    public static int generateRandomValue() {
        Faker faker = new Faker();
        return faker.number().numberBetween(1, 100);
    }

    public static String generatePhone() {
        Faker faker = new Faker();
        return faker.phoneNumber().cellPhone();
    }

    public static String generateDays() {
        Faker faker = new Faker();
        return faker.number().digits(1);
    }

    public static String generateNumberMore() {
        Faker faker = new Faker();
        return faker.number().digits(100);
    }

    public static String generateRate() {
        Faker faker = new Faker();
        return faker.number().digits(5);
    }

    public static String generateRandom1() {
        Faker faker = new Faker();
        return faker.number().digits(1);
    }

    public static String generateRandom2() {
        Faker faker = new Faker();
        return faker.number().digits(2);
    }

    public static String generateRandom3() {
        Faker faker = new Faker();
        return faker.number().digits(3);
    }

    public static String generateRandom4() {
        Faker faker = new Faker();
        return faker.number().digits(4);
    }

    public static String generateTaxRate() {
        Faker faker = new Faker();
        return faker.number().digits(2);
    }

    public static String generateOffice() {
        Faker faker = new Faker();
        return faker.company().name();
    }

    public static String generateOffice1() {
        Faker faker = new Faker();
        return faker.company().industry();
    }

    public static String generateLatitude() {
        Faker faker = new Faker();
        return faker.address().latitude();
    }

    public static String generateLongitude() {
        Faker faker = new Faker();
        return faker.address().longitude();
    }
}
