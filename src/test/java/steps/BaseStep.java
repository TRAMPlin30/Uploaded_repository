package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static drivers.DriverFactory.*;

public class BaseStep {


    @Before()
    public void setUp() {
        getDriver();
    }

    @After()
    public void tearDown() {
        cleanUpDriver();
    }
}
