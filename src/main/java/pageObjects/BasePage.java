package pageObjects;

import drivers.DriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver = DriverFactory.getDriver();

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void sendValue(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void waitWebElementIsVisible(WebElement element) {
        Wait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(2));
        waiter.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitWebElementIsClickable(WebElement button) {
        Wait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(2));
        waiter.until(ExpectedConditions.elementToBeClickable(button));
    }

    public void waitWebElementIsInvisible(WebElement element) {
        Wait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(2));
        waiter.until(ExpectedConditions.invisibilityOf(element));
    }

    public void smartWaiterForElementIsVisible(WebElement element) throws InterruptedException {
        int counter = 15;
        while (counter > 0) {
            try {
                waitWebElementIsVisible(element);
                break;
            } catch (NoSuchElementException e) {
                counter--;
                System.out.println(counter);
                Thread.sleep(500);
            }
        }
    }
}
