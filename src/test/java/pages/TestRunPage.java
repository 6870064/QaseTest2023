package pages;

import elements.CustomDropdown;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

import static tests.BaseTest.driver;

@Log4j2
public class TestRunPage extends BasePage {

    public static final By TEST_RUNS_SUBMENU = By.xpath("//*[text()='Test Runs']");
    public static final By START_NEW_TEST_RUN_BUTTON = By.xpath("//*[text()='Start new test run']");
    public static final By ADD_CASES_BUTTON = By.id("edit-run-add-cases-button");
    public static final By CHECKBOX = By.id("suite-0-checkbox");
    public static final By DONE_BUTTON = By.id("select-cases-done-button");
    public static final By START_RUN_BUTTON = By.id("save-run-button");

    public TestRunPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public boolean startNewTestRunButtonIsDisplayed() {
        return BasePage.isElementExist(START_NEW_TEST_RUN_BUTTON);
    }

    @Step("Click on test run submenu")
    public void testRunsSubmenuClick() {

        log.info("Click on test run submenu");

        driver.findElement(TEST_RUNS_SUBMENU).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Click on the button to start of the test run")
    public void setStartNewTestRunButtonClick() {

        log.info("Click on the button to start of the test run");

        driver.findElement(START_NEW_TEST_RUN_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Enter title of the test run")
    public void enterRunTitle(String testRunTitle) {

        log.info(String.format("Enter title '%s' of the test run", testRunTitle));

        new Input(driver, "Run title").write(testRunTitle);
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Enter description of the test run")
    public void enterTestRunDescription(String testRunDescription) {

        log.info("Enter description of the test run");

        new Input(driver, "Description").write(testRunDescription);
        AllureUtils.takeScreenshot(driver);
    }

    public void planValueSelect(String planValue) {

        log.info("Select of Plan value");

        new Dropdown(driver, "Plan", "Select...", planValue).dropDownClick();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Select assignee of the test run")
    public void assigneeSelect(String assigneeValueToClick) {

        log.info("Select assignee of the test run");

        new CustomDropdown(driver, "Default assignee", "Select...", assigneeValueToClick).dropDownClick();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Click on 'Add cases' button")
    public void setAddCasesButtonClick() {

        log.info("Click on 'Add cases' button");

        driver.findElement(ADD_CASES_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Click on checkbox")
    public void checkboxClick() {

        log.info("Click on checkbox");

        driver.findElement(CHECKBOX).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Click on 'Done' button")
    public void doneButtonClick() {

        log.info("Click on 'Done' button");

        driver.findElement(DONE_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Click on 'Start test run' button")
    public void startRunButtonClick() {

        log.info("Click on 'Start test run' button");

        driver.findElement(START_RUN_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }
}
