package org.example.helpfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//--весь класс как реализация PageObject
public class LoginPage {

    //--ниже PageFactory
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //--ниже PageElement
    @FindBy(id = "user-name")
    private WebElement loginField;

    @FindBy(css = "input#login-button")
    private WebElement loginBtn;

    public LoginPage inputLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage inputPasswd(String passwd) {
        //--применение Chain of invocations
        driver.findElement(By.id("password")).sendKeys(passwd);
        return this;
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void loginFromProperties() {
        inputLogin(ConfProperties.getLogin());
        inputPasswd(ConfProperties.getPassword());
        clickLoginBtn();
    }

    public void loginWithParameters(String username, String password) {
        //--применение Chain of invocations
        inputLogin(username)
                .inputPasswd(password)
                .clickLoginBtn();
    }
}
