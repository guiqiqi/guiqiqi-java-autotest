package task3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class SubTaskB extends DriverSetup {
    @Test
    public void testBrowserTitle() {
        // 2. Assert browser title
        assertEquals(homePage.getTitle(), ExpectedData.SITE_NAME);
    }

    @Test
    public void testLogin() {
        // 4. Assert user is logged in
        assertEquals(homePage.getLoggedName(), ExpectedData.LOGGED_USER_NAME);
    }

    @Test
    public void testElements() {
        // 5. Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver, homePage);

        // 6. Select checkboxes
        differentElementsPage.selectCheckbox("Water");
        differentElementsPage.selectCheckbox("Wind");

        // 7. Select radio
        differentElementsPage.selectRadio("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectDropdownOption("Yellow");

        // 9. Assert logs
        assertEquals(differentElementsPage.getLogs(), ExpectedData.DIFFERENT_ELEMENTS_LOGS);
    }
}
