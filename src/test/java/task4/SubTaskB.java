package task4;

import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Second task using Steps")
public class SubTaskB extends DriverSetup {
    @Story("Testing the Different Elements page")
    @Test
    public void testTaskB() {
        // 2. Assert browser title
        assertion.assertHomePageTitle(ExpectedData.SITE_NAME);

        // 4. Assert user is logged in
        assertion.assertUserLoggedIn(ExpectedData.LOGGED_USER_NAME);

        // 5. Open through the header header menu Service -> Different Elements Page
        action.navigateToDifferentElementsPage();

        // 6. Select checkboxes
        action.selectCheckboxes("Water", "Wind");

        // 7. Select radio
        action.selectRadio("Selen");

        // 8. Select item in dropdown
        action.selectDropdownOption("Yellow");

        // 9. Assert logs
        assertion.assertLogs(ExpectedData.DIFFERENT_ELEMENTS_LOGS);
    }
}
