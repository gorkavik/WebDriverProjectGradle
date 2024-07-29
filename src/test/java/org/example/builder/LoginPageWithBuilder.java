package org.example.builder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithBuilder {

    private WebDriver driver;
    private WebElement loginField;
    private WebElement passField;
    private WebElement loginBtn;

    public LoginPageWithBuilder(WebDriver driver, Builder builder) {
        this.loginField=builder.loginField;
        this.passField=builder.passField;
        this.loginBtn=builder.loginBtn;
        this.driver = driver;
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public static class Builder {

        public WebDriver driver;
        @FindBy(id = "user-name")
        private WebElement loginField;
        @FindBy(id = "password")
        private WebElement passField;
        @FindBy(css = "input#login-button")
        private WebElement loginBtn;

        public Builder(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver=driver;
        }

        public Builder inputLogin(String login) {
            this.loginField.sendKeys(login);
            return this;
        }

        public Builder inputPass(String pass) {
            this.passField.sendKeys(pass);
            return this;
        }

        public LoginPageWithBuilder build() {
            return new LoginPageWithBuilder(driver,this);
        }
    }
}
