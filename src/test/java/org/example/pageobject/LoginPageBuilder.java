package org.example.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageBuilder {

    private WebDriver driver;
    private WebElement loginField;
    private WebElement passField;
    private WebElement loginBtn;

    private LoginPageBuilder(Builder builder) {
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
    public static class Builder {

        private WebDriver driver;

        @FindBy(id = "user-name")
        private WebElement loginField;

        @FindBy(id = "password")
        private WebElement passField;

        @FindBy(css = "input#login-button")
        private WebElement loginBtn;
//
//        public Builder(WebDriver driver) {
//            PageFactory.initElements(driver, this);
//            this.driver = driver;
//        }

        public Builder inputLogin(String login) {
            loginField.sendKeys(login);
            return this;
        }

        public Builder inputPass(String pass) {
            passField.sendKeys(pass);
            return this;
        }



        public LoginPageBuilder build() {
            return new LoginPageBuilder(this);
        }
    }
}
