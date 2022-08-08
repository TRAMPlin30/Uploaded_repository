package constants.locators;

public class Locators {

    public interface FindRout {
        String MAP = "map",
                MAIN_LABEL = "//h1/a[@class='geolink']",
                DIRECTION_BUTTON = "//div[@id='sidebar']//a[@href='/directions']",
                INPUT_FROM = "//div[@id='sidebar']//input[@id='route_from']",
                INPUT_TO = "//div[@id='sidebar']//input[@id='route_to']",
                BUTTON_GO = "//div[@id='sidebar']//input[@class='routing_go btn btn-sm btn-primary']",
                SIDEBAR_CONTENT = "//div[@id='sidebar_content']",
                SIDEBAR_LOADER = "//div[@id='sidebar_loader']/img[@class='loader']",
                DISTANCE = "//div[@id='sidebar_content']/p[contains(text(),'km.')]";
    }
}
