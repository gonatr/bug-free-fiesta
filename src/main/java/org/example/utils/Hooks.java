package org.example.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setupBrowser() {
        try {
            Properties properties = new Properties();
            FileInputStream propertiesFile = new FileInputStream("src/main/java/org/example/config/config.properties");
            properties.load(propertiesFile);

            ChromeOptions chrome_options = getChromeOptions();

            driver = new ChromeDriver(chrome_options);
            driver.get(properties.getProperty("baseUrl"));

            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
            System.out.println("Starting the test....");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.addArguments("--headless=new");
        chrome_options.addArguments("--incognito");
        chrome_options.addArguments("--remote-allow-origins=*");
        chrome_options.addArguments("--start-maximized");
        chrome_options.addArguments("--disable-extensions");
        chrome_options.addArguments("--disable-web-security");
        chrome_options.addArguments("--disable-popup-blocking");
        chrome_options.addArguments("--ignore-certificate-errors");
        chrome_options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return chrome_options;
    }

    @After
    public void atClose(Scenario scenario) {
        System.out.println("End of the test.");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);

        // validate if scenario has failed
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        } else {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        }
        driver.quit();
    }
}