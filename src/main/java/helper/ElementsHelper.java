package helper;



import base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsHelper {
    private  WebDriver driver;
    private WaitHelper wait ;
    private LoggerHelper loggerHelper;

    public ElementsHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
        this.loggerHelper = new LoggerHelper();
    }
    public void clickElement(By locator){
        wait.waitBeforeInteract(locator);
        DriverManager.getDriver().findElement(locator).click();
    }
    public void addTextToField(By locator,String text){
        wait.waitBeforeInteract(locator);
        DriverManager.getDriver().findElement(locator).sendKeys(text);
    }
    public String getTextFromField(By locator){
        try{
            wait.waitBeforeInteract(locator);
            loggerHelper.logger.info("getTextFromField "+locator+" : "+DriverManager.getDriver().findElement(locator).getText());
            return DriverManager.getDriver().findElement(locator).getText();
        }catch (Exception e){
            loggerHelper.logger.error("Exception : can not retrieve Element Text");
            return e.getMessage();
        }
    }


}
