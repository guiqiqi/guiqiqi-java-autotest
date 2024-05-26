package task3;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftSection {
    @FindBy(css = "#mCSB_1_container > ul > li")
    private List<WebElement> items;

    public LeftSection(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getItems() {
        return this.items;
    }

    public Integer getItemSize() {
        return this.items.size();
    }

    public List<String> getItemsNames() {
        return this.items.stream().map(WebElement::getText).toList();
    }
}
