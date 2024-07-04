package org.example.helpfiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement firstElement;

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getFirstItem() {
        return firstElement.getText();
    }
}
