package org.example.helpfiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
// весь класс как реализация PageObject
public class LoginPage {
    // ниже PageFactory
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    //ниже PageElement
    @FindBy(id="user-name")
    private WebElement loginField;

    @FindBy(css = "input#login-button")
    private WebElement loginBtn;

    @FindBy(id = "password")
    private WebElement passwdField;

    public void inputLogin(String login) {
        loginField.sendKeys(login); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    public void clickLoginBtn() {
        loginBtn.click(); }
}
