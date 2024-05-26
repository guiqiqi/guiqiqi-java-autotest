package task4;

import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("First task using Steps")
public class SubTaskA extends DriverSetup {
    @Story("Testing the Home Page")
    @Test
    public void testTaskA() {
        // 2. Assert browser title
        assertion.assertHomePageTitle(ExpectedData.SITE_NAME);

        // 4. Assert user is logged in
        assertion.assertUserLoggedIn(ExpectedData.LOGGED_USER_NAME);

        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        assertion.assertHeaderSectionItemsProperties(
                ExpectedData.HEADER_SECTION_ITEMS.size(),
                ExpectedData.HEADER_SECTION_ITEMS);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        assertion.assertIndexPageImages(ExpectedData.BENEFIT_ICONS.size());

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        assertion.assertIndexPageTexts(ExpectedData.BENEFIT_ICONS.size(), ExpectedData.BENEFIT_ICONS);

        // 8. Assert that there is the iframe with frame button exists
        assertion.assertFrameExsitence();

        // 9. Switch to the iframe and check that there is “Frame ”Button in the iframe
        assertion.assertFrameButtonExistence();

        // 10. Switch to original window back
        action.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        assertion.assertLeftSectionProperties(
                ExpectedData.LEFT_SECTION_ITEMS.size(),
                ExpectedData.LEFT_SECTION_ITEMS);
    }
}
