package task4;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSection {
    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> items;

    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li > a > span")
    private WebElement serviceDropdown;

    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(8) > a")
    private WebElement differentElements;

    public HeaderSection(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void clickServiceDropdown() {
        this.serviceDropdown.click();
    }

    public void clickDifferentElements() {
        this.differentElements.click();
    }

    public List<WebElement> getItems() {
        return this.items;
    }

    public Integer getItemsSize() {
        return this.items.size();
    }

    public List<String> getItemsNames() {
        return this.items.stream().map(WebElement::getText).toList();
    }
}
