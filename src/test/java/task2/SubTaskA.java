package task2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SubTaskA extends DriverSetup {
    @Test
    public void testTask() {
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 4. Assert Username is logged in
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<WebElement> headerItems = driver.findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8"))
                .findElements(By.xpath("./child::*"));
        final int EXPECTED_HEADER_ITEMS_SIZE = 4;
        softAssert.assertEquals(headerItems.size(), EXPECTED_HEADER_ITEMS_SIZE);
        headerItems.forEach(item -> softAssert.assertTrue(item.isDisplayed()));
        softAssert.assertEquals(headerItems.stream().map(WebElement::getText).toList(),
                List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        List<WebElement> benefitImages = driver.findElements(By.className("benefit-icon"));
        final int EXPECTED_BENEFIT_IMAGES_SIZE = 4;
        softAssert.assertEquals(benefitImages.size(), EXPECTED_BENEFIT_IMAGES_SIZE);
        benefitImages.forEach(image -> softAssert.assertTrue(image.isDisplayed()));

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<WebElement> benefitTexts = driver.findElements(By.className("benefit-txt"));
        final int EXPECTED_BENEFIT_TEXTS_SIZE = 4;
        softAssert.assertEquals(benefitTexts.size(), EXPECTED_BENEFIT_TEXTS_SIZE);
        benefitTexts.forEach(text -> softAssert.assertTrue(text.isDisplayed()));
        softAssert.assertEquals(
                benefitTexts.stream()
                        .map(WebElement::getText)
                        .map(text -> text.replace("\n", " "))
                        .toList(),
                List.of(
                        "To include good practices and ideas from successful EPAM project",
                        "To be flexible and customizable",
                        "To be multiplatform",
                        "Already have good base (about 20 internal and some external projects), wish to get more…"));

        // 8. Assert that there is the iframe with “Frame Button” exist
        final String EXPECTED_IFRAME_SRC = "https://jdi-testing.github.io/jdi-light/frame-button.html";
        softAssert.assertEquals(driver.findElement(By.tagName("iframe")).getAttribute("src"),
                EXPECTED_IFRAME_SRC);

        // 9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        final String EXPECTED_FRAME_VALUE = "Frame Button";
        softAssert.assertEquals(driver.findElement(By.id("frame-button")).getAttribute("value"),
                EXPECTED_FRAME_VALUE);

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        List<WebElement> leftSectionItems = driver.findElement(By.cssSelector("ul.sidebar-menu.left"))
                .findElements(By.xpath("./child::*"));
        leftSectionItems.forEach(item -> softAssert.assertTrue(item.isDisplayed()));
        softAssert.assertEquals(leftSectionItems.stream().map(WebElement::getText).toList(), List.of(
                "Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));

        // Assert all in soft assert
        softAssert.assertAll();
    }
}
