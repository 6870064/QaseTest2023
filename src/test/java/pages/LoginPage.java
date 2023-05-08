package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

import static tests.BaseTest.driver;

@Log4j2
public class LoginPage extends BasePage {

    public static final String INPUT_LOCATOR = "//label[text()='%s']/../input";
    public static final By CHECKBOX_INPUT = By.className("custom-control-indicator");
    public static final By LOGIN_BUTTON = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page")
    public void pageOpen() {
        driver.get(BaseTest.BASE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return BasePage.isElementExist(LOGIN_BUTTON);
    }

    @Step("Login by valid user")
    public void login(String loginFieldTitle, String userLogin, String passwordFieldTitle, String userPassword) {
        log.info(String.format("Valid login with user login: {} and valid password: {}",userLogin, userPassword));
        setValue(loginFieldTitle, userLogin);
        setValue(passwordFieldTitle, userPassword);
        clickCheckBoxInput();
        clickLoginButton();
    }

    public void setValue(String fieldTitle, String input) {
        log.info("Entering value {} in the field {}", input, fieldTitle);
        driver.findElement(By.xpath(String.format(INPUT_LOCATOR, fieldTitle))).sendKeys(input);
    }

    @Step("Checkbox Input was checked")
    public void clickCheckBoxInput(){
        log.info("Clicking on checkbox 'Remember me'");
        driver.findElement(CHECKBOX_INPUT).click();
    }

    @Step("Click on Login button")
    public void clickLoginButton(){
        log.info("Clicking on [Login] button");
        driver.findElement(LOGIN_BUTTON).click();
    }
}
