package task4;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class StepsSetup {
    protected static WebDriver webDriver;
    protected static Properties properties;
    protected static HomePage homePage;
    protected static DifferentElementsPage differentElementsPage;

    public StepsSetup(WebDriver webDriver, Properties properties) {
        StepsSetup.webDriver = webDriver;
        StepsSetup.properties = properties;
    }
}
