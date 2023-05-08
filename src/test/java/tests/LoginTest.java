package tests;

import io.qameta.allure.Feature;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Feature("Login Feature")
    @Test(description = "Username should be required")
    public void validUserLogin() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.setValue(loginFieldTitle, USER_LOGIN);
        loginPage.setValue(passwordFieldTitle, USER_PASSWORD);
        loginPage.clickCheckBoxInput();
        loginPage.clickLoginButton();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    }
}