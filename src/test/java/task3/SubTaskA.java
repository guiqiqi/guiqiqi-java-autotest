package task3;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SubTaskA extends DriverSetup {
    @Test
    public void testTaskA() {
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(homePage.getTitle(), ExpectedData.SITE_NAME);

        // 4. Assert user is logged in
        softAssert.assertEquals(homePage.getLoggedName(), ExpectedData.LOGGED_USER_NAME);

        // 5. Assert that there are 4 items on the header section are displayed , and they have proper texts
        softAssert.assertEquals(homePage.getHeaderSection().getItemsSize(), ExpectedData.HEADER_SECTION_ITEMS.size());
        softAssert.assertEquals(homePage.getHeaderSection().getItemsNames(), ExpectedData.HEADER_SECTION_ITEMS);
        homePage.getHeaderSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softAssert.assertEquals(homePage.getBenefitIconsSize(), ExpectedData.BENEFIT_ICONS.size());
        homePage.getBenefitIcons().forEach(icon -> {
            softAssert.assertTrue(icon.isDisplayed());
        });

        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        softAssert.assertEquals(homePage.getBenefitIconsTextsSize(), ExpectedData.BENEFIT_ICONS.size());
        softAssert.assertEquals(homePage.getBenefitIconsTextsStrings(), ExpectedData.BENEFIT_ICONS);

        // 8. Assert that there is an iframe with frame button exists
        softAssert.assertTrue(homePage.getFrame().isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame ”Button in the iframe
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());

        // 10. Switch to original window back
        homePage.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softAssert.assertEquals(homePage.getLeftSection().getItemSize(), ExpectedData.LEFT_SECTION_ITEMS.size());
        homePage.getLeftSection().getItems().forEach(item -> {
            softAssert.assertTrue(item.isDisplayed());
        });
        softAssert.assertEquals(homePage.getLeftSection().getItemsNames(), ExpectedData.LEFT_SECTION_ITEMS);

        softAssert.assertAll();
    }
}
