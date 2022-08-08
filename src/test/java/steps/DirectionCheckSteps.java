package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.pages.DirectionPage;
import pageObjects.pages.MainPage;
import utils.ElementExceptionInDrpDownList;


public class DirectionCheckSteps {

    MainPage mainPage = new MainPage();
    DirectionPage directionPage = new DirectionPage();

    @When("Launch OpenStreetMap application in Chrome browser")
    public void launch_open_street_map_application_in_chrome_browser() {
        mainPage.
                runOpenStreetMap().
                checkMainLabelIsDisplayed().
                checkMainLabelTextIsProperly();
    }

    @And("Click on the button directions")
    public void click_on_the_button_directions() {
        mainPage.
                clickButtonDirection().
                checkDirectionUrlIslCorrect();
    }

    @And("Enter name of point A in the field {string}")
    public void enter_name_of_point_a_in_the_field(String from) {
        directionPage.
                fillInputFieldFrom(from);

    }

    @And("Enter name of point B in the field {string}")
    public void enter_name_of_point_b_in_the_field(String to) {
        directionPage.
                fillInputFieldTo(to);
    }

    @And("In the transport option dropdown list select {string}")
    public void in_the_transport_option_dropdown_list_select(String transport) throws ElementExceptionInDrpDownList {
        directionPage.
                selectTransport(transport);
    }

    @And("Click on the button Go")
    public void click_on_the_button_go() {
        directionPage.
                clickButtonGo();
    }

    @Then("Make sure the distance matches {int}")
    public void make_sure_the_distance_matches(Integer expectedDistance) throws InterruptedException {
        Integer actualDistance = directionPage.getActualDistance();
        Assert.assertEquals(actualDistance, expectedDistance, "Distance between points do not match!");
    }

}
