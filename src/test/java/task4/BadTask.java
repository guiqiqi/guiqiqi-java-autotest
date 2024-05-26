package task4;

import org.testng.annotations.Test;

public class BadTask extends DriverSetup {
    @Test
    public void testBadTask() {
        // 2. Assert browser title - a random stirng :)
        assertion.assertHomePageTitle("A WRONG SITENAME");
    }
}
