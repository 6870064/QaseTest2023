package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestRepositoryPage extends BasePage {

    public static final By CREATE_NEW_CASE = By.className("btn btn-primary ms-3");

    public TestRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
