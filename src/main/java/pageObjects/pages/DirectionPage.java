package pageObjects.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.BasePage;
import utils.ElementExceptionInDrpDownList;
import utils.SelectTransportByValue;

import static constants.locators.Locators.FindRout.*;
import static constants.urls.Urls.Pages.DIRECTION_PAGE;

@Getter
public class DirectionPage extends BasePage {

    @FindBy(xpath = INPUT_FROM)
    protected WebElement inputFrom;
    @FindBy(xpath = INPUT_TO)
    protected WebElement inputTo;
    @FindBy(xpath = BUTTON_GO)
    protected WebElement buttonGo;
    @FindBy(xpath = SIDEBAR_CONTENT)
    protected WebElement sideBarContent;
    @FindBy(xpath = SIDEBAR_LOADER)
    protected WebElement sideBarLoader;
    @FindBy(xpath = DISTANCE)
    protected WebElement distance;

    String transportName = "//div[@id='sidebar']//select[@class='routing_engines form-select form-select-sm']/option[@value='%s']";

    public DirectionPage() {
        super();
    }

    public void checkDirectionUrlIslCorrect() {
        Assert.assertEquals(driver.getCurrentUrl(), DIRECTION_PAGE, "Incorrect URL!!!");
    }

    public void fillInputFieldFrom(String from) {
        waitWebElementIsVisible(inputFrom);
        waitWebElementIsClickable(inputFrom);
        clickElement(inputFrom);
        sendValue(inputFrom, from);
    }

    public void fillInputFieldTo(String to) {
        waitWebElementIsVisible(inputTo);
        waitWebElementIsClickable(inputTo);
        clickElement(inputTo);
        sendValue(inputTo, to);
    }

    public void selectTransport(String transport) throws ElementExceptionInDrpDownList {
        int valueOfTransport = SelectTransportByValue.selectTransport(transport);
        if (valueOfTransport != 404) {
            String xpathTo = String.format(transportName, valueOfTransport);
            WebElement byTransport = driver.findElement(By.xpath(xpathTo));
            clickElement(byTransport);
        } else {
            throw new ElementExceptionInDrpDownList("The specified element is not in the list!!!");
        }
    }

    public void clickButtonGo() {
        waitWebElementIsVisible(buttonGo);
        waitWebElementIsClickable(buttonGo);
        clickElement(buttonGo);
    }

    public Integer getActualDistance() throws InterruptedException {
        smartWaiterForElementIsVisible(distance);
        String getAttributeDistance = distance.getAttribute("textContent").split("km", 2)[0];
        System.out.println(getAttributeDistance);
        String actualDistanceStr = getAttributeDistance.replaceAll("[^0-9]", "");
        System.out.println(actualDistanceStr);
        return Integer.valueOf(actualDistanceStr);
    }
}
