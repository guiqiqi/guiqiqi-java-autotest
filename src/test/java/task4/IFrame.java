package task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFrame {
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public IFrame(WebDriver webDriver) {
        webDriver.switchTo().frame("frame");
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getFrameButton() {
        return this.frameButton;
    }
}
