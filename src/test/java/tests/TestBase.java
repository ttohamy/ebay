package tests;

import base.DriverManager;
import helper.LoggerHelper;
import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    SoftAssert softAssert;
    public static WebDriver driver;
    HomePage homePage ;
    LoggerHelper loggerHelper ;

    @BeforeClass
    protected void getSoftAssert() {
        softAssert = new SoftAssert();
    }

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Boolean> value = new HashMap<>();
            value.put("credentials_enable_service", false);
            value.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", value);
            options.addArguments("--disable-features=PasswordSave,PasswordAutofill");
            driver = new ChromeDriver(options);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();

        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            DriverManager.setDriver(driver);
        }
        else if (browserName.equalsIgnoreCase("mobileView")) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "Nexus 5");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            driver = new ChromeDriver(chromeOptions);
            DriverManager.setDriver(driver);

        } else if (browserName.equalsIgnoreCase("chrome-headless")) {
            System.out.println("Headless is perfect");
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            option.setPageLoadStrategy(PageLoadStrategy.NONE);
            option.addArguments("window-size=2000,3000");
//            driver = new ChromeDriver(option);
            try {
                //should be selenium-chrome "container name" instead of localhost to run on jenkins container
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),option);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @BeforeClass
    public void initObjects(){
        homePage = new HomePage();
        loggerHelper = new LoggerHelper();
    }
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String currentDir = System.getProperty("user.dir")+"/screenshots/" ;
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(currentDir+ testResult.getName() + "-"+formater.format(calendar.getTime()) +".jpg"));
        }
    }

    @AfterClass
    public void closeDriver() {
//        driver.quit();
    }

}
