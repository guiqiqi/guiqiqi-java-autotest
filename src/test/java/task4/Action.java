package task4;

import java.util.Properties;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class Action extends StepsSetup {
    public Action(WebDriver webDriver, Properties properties) {
        super(webDriver, properties);
    }

    @Step("Navigating to Home Page")
    public void navigateToHomePage() {
        homePage = new HomePage(webDriver, properties.getProperty("site.url"));
    }

    @Step("Logging in")
    public void performLogin() {
        homePage.performLogin(
                properties.getProperty("user.name"),
                properties.getProperty("user.password"));
    }

    @Step("Switching to the original window")
    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    @Step("Navigating to different elements page")
    public void navigateToDifferentElementsPage() {
        differentElementsPage = new DifferentElementsPage(webDriver, homePage);
    }

    @Step("Selecting checkboxes")
    public void selectCheckboxes(String... names) {
        Stream.of(names).forEach(name -> differentElementsPage.selectCheckbox(name));
    }

    @Step("Selecting radio")
    public void selectRadio(String name) {
        differentElementsPage.selectRadio(name);
    }

    @Step("Selecting dropdown option")
    public void selectDropdownOption(String name) {
        differentElementsPage.selectDropdownOption(name);
    }
}
