package task4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Step;

public class Assertion extends StepsSetup {
    public Assertion(WebDriver webDriver, Properties properties) {
        super(webDriver, properties);
    }

    @Step("Asserting Home Page's title")
    public void assertHomePageTitle(String expectedTitle) {
        assertEquals(homePage.getTitle(), expectedTitle);
    }

    @Step("Asserting user is logged in")
    public void assertUserLoggedIn(String expectedUsername) {
        assertEquals(homePage.getLoggedName(), expectedUsername);
    }

    @Step("Asserting Header Seciton items properties")
    public void assertHeaderSectionItemsProperties(
            Integer expectedItemsSize,
            List<String> expectedItemsNames) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getHeaderSection().getItemsSize(), expectedItemsSize);
        softAssert.assertEquals(homePage.getHeaderSection().getItemsNames(), expectedItemsNames);
        homePage.getHeaderSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });
        softAssert.assertAll();
    }

    @Step("Asserting Index Page images properties")
    public void assertIndexPageImages(Integer expectedImagesSize) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getBenefitIconsSize(), expectedImagesSize);
        homePage.getBenefitIcons().forEach(icon -> {
            softAssert.assertTrue(icon.isDisplayed());
        });
        softAssert.assertAll();
    }

    @Step("Asserting Index Page texts properties")
    public void assertIndexPageTexts(
            Integer expectedTextsSize,
            List<String> expectedTextsStrings) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getBenefitIconsTextsSize(), expectedTextsSize);
        softAssert.assertEquals(homePage.getBenefitIconsTextsStrings(), expectedTextsStrings);
        softAssert.assertAll();
    }

    @Step("Asserting iframe existence")
    public void assertFrameExsitence() {
        assertTrue(homePage.getFrame().isDisplayed());
    }

    @Step("Asserting Frame Button existence")
    public void assertFrameButtonExistence() {
        assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Step("Asserting Left Section properties")
    public void assertLeftSectionProperties(
            Integer expectedItemsSize,
            List<String> expectedItemsNames) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getLeftSection().getItemSize(), expectedItemsSize);
        softAssert.assertEquals(homePage.getLeftSection().getItemsNames(), expectedItemsNames);
        homePage.getLeftSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });
        softAssert.assertAll();
    }

    @Step("Asserting logs")
    public void assertLogs(List<String> logs) {
        assertEquals(differentElementsPage.getLogs(), logs);
    }
}
