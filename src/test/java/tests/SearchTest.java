package tests;

import base.DriverManager;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import utils.ConfigReader;

@Epic("Search Module")
@Feature("Search For mazda mx-5")
public class SearchTest extends TestBase {

    @Test(description = "Search")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensures that a user can find mazda mx-5 car with manual transmission by using search field")
    public void CheckThatTheUserCanSearch(){
        homePage.openURL();
        softAssert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("ebay.com"));
        homePage.search(ConfigReader.getProperty("SEARCH_TEXT"));
        loggerHelper.logger.info("Search Result Count : "+ homePage.getSearchResultCount());
        homePage.selectManualTransmission();
        loggerHelper.logger.info("Search Result Count After Selecting Manual Transmission : "+ homePage.getSearchResultCount());
        softAssert.assertTrue(homePage.getSearchResultCount().contains("1"));
        softAssert.assertAll();
    }
}
