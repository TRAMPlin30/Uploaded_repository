package pageObjects.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.BasePage;

import static constants.locators.Locators.FindRout.*;
import static constants.urls.Urls.Pages.MAIN_PAGE;

@Getter
public class MainPage extends BasePage {

    @FindBy(id = MAP)
    protected WebElement map;
    @FindBy(xpath = MAIN_LABEL)
    protected WebElement mainLabel;
    @FindBy(xpath = DIRECTION_BUTTON)
    protected WebElement directionButton;

    public MainPage() {
        super();
    }

    public MainPage runOpenStreetMap() {
        super.navigateToPage(MAIN_PAGE);
        return this;
    }

    public MainPage checkMapIsDisplayed() {
        Assert.assertTrue(map.isDisplayed(), "Map is not displayed!!!");
        return this;
    }

    public MainPage checkMainLabelIsDisplayed() {
        Assert.assertTrue(mainLabel.isDisplayed(), "Main Label is not displayed!!!");
        return this;
    }

    public void checkMainLabelTextIsProperly() {
        Assert.assertEquals(mainLabel.getAttribute("innerText"), " OpenStreetMap", "Incorrect text in Main Label");
    }

    public DirectionPage clickButtonDirection() {
        waitWebElementIsVisible(directionButton);
        waitWebElementIsClickable(directionButton);
        clickElement(directionButton);
        return new DirectionPage();
    }
}
