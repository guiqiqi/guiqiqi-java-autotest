package task3;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver webDriver;
    private final HeaderSection headerSection;
    private final LeftSection leftSection;

    @FindBy(id = "name")
    private WebElement loginUsername;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(css = "html > body > header > div > nav > ul.uui-navigation.navbar-nav.navbar-right > li > a > span")
    private WebElement loginDropdownButton;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitIconsTexts;

    @FindBy(tagName = "iframe")
    private WebElement iframe;

    public HomePage(WebDriver webDriver, String url) {
        this.webDriver = webDriver;

        // 1. Open test site by URL
        this.webDriver.navigate().to(url);

        PageFactory.initElements(this.webDriver, this);
        headerSection = new HeaderSection(webDriver);
        leftSection = new LeftSection(webDriver);
    }

    public void performLogin(String username, String password) {
        this.loginDropdownButton.click();
        this.loginUsername.sendKeys(username);
        this.loginPassword.sendKeys(password);
        this.loginButton.click();
    }

    public String getTitle() {
        return this.webDriver.getTitle();
    }

    public String getLoggedName() {
        return this.username.getText();
    }

    public HeaderSection getHeaderSection() {
        return this.headerSection;
    }

    public Integer getBenefitIconsSize() {
        return this.benefitIcons.size();
    }

    public List<WebElement> getBenefitIcons() {
        return this.benefitIcons;
    }

    public Integer getBenefitIconsTextsSize() {
        return this.benefitIconsTexts.size();
    }

    public List<String> getBenefitIconsTextsStrings() {
        return this.benefitIconsTexts.stream().map(WebElement::getText).toList();
    }

    public LeftSection getLeftSection() {
        return this.leftSection;
    }

    public WebElement getFrame() {
        return this.iframe;
    }

    public WebElement getFrameButton() {
        return new IFrame(this.webDriver).getFrameButton();
    }

    public void switchToOriginalWindow() {
        this.webDriver.switchTo().defaultContent();
    }
}
