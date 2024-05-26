package task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverSetup {
    protected static WebDriver webDriver;
    protected static Action action;
    protected static Assertion assertion;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Path.of("src/test/resources/data.properties")));
        } catch (IOException error) {
            throw new RuntimeException(error);
        }

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        action = new Action(webDriver, properties);
        assertion = new Assertion(webDriver, properties);

        // 3. Perform login
        action.navigateToHomePage();
        action.performLogin();
    }

    @AfterClass
    public static void exit() {
        // 10. Close browser
        webDriver.close();
    }
}
