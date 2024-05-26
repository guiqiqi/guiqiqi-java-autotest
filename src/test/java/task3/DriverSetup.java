package task3;

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
    protected static HomePage homePage;

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

        homePage = new HomePage(webDriver, properties.getProperty("site.url"));

        // 3. Perform login
        homePage.performLogin(
                properties.getProperty("user.name"),
                properties.getProperty("user.password"));
    }

    @AfterClass
    public static void exit() {
        // 10. Close browser
        webDriver.close();
    }
}
