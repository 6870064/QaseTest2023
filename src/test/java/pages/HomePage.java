package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {

    public static final By CREATE_BUTTON = By.id("createButton");
    public static final By RESEND_BUTTON = By.id("resend");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return BasePage.isElementExist(CREATE_BUTTON);
    }

}
