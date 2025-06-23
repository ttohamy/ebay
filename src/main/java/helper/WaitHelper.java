package helper;

import base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class WaitHelper {
    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void waitBeforeInteract(By locator) {
        FluentWait wait = new FluentWait(DriverManager.getDriver()).withTimeout(Duration.ofSeconds(7)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class).ignoring(TimeoutException.class).withMessage(locator+" Not Found");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
