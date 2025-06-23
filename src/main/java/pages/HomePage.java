package pages;

import base.DriverManager;
import helper.ElementsHelper;
import helper.LoggerHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class HomePage {
    private ElementsHelper elementsHelper;
    WebDriver driver;
    private String URL = ConfigReader.getProperty("URL");
    private By searchField = By.id("gh-ac");
    private By searchButton = By.id("gh-search-btn");
    private By searchResultCount = By.xpath("//*[@id=\"mainContent\"]/div[2]/div/div[1]/div[1]/div[1]/h1/span[1]");
    private By manualTransmissionCheckBox = By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div");
    LoggerHelper loggerHelper ;

    public HomePage() {
        this.driver = DriverManager.getDriver();
        this.elementsHelper = new ElementsHelper(driver);
        this.loggerHelper = new LoggerHelper();

    }
    public void openURL(){
        DriverManager.getDriver().navigate().to(URL);
    }
    public void search(String text){
        elementsHelper.addTextToField(searchField,text);
        elementsHelper.clickElement(searchButton);
    }
    public String getSearchResultCount(){
        return elementsHelper.getTextFromField(searchResultCount);
    }
    public void selectManualTransmission(){
        elementsHelper.clickElement(manualTransmissionCheckBox);
    }

}
