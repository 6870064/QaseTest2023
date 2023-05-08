package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

import static tests.BaseTest.driver;

@Log4j2
public class TestPlanPage extends BasePage {

    public static final By TEST_PLANS_SUBMENU = By.xpath("//*[text()='Test Plans']");
    public static final By CREATE_PLAN_BUTTON = By.id("createButton");
    public static final By ADD_CASES_BUTTON = By.id("edit-plan-add-cases-button");
    public static final By CHECKBOX = By.id("suite-0-checkbox");
    public static final By ADD_CASES_DONE_BUTTON = By.id("select-cases-done-button");
    public static final By SAVE_PLAN_BUTTON = By.id("save-plan");

    public TestPlanPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public boolean createPlanButtonIsDisplayed() {
        return BasePage.isElementExist(CREATE_PLAN_BUTTON);

    }

    @Step("Click on 'Test plan' submenu")
    public void testPlansButtonClick() {
        driver.findElement(TEST_PLANS_SUBMENU).click();

        log.info("Click on 'Test plan' submenu");
    }

    @Step("Click on 'Create test plan' button")
    public void createPlanButtonClick() {
        driver.findElement(CREATE_PLAN_BUTTON).click();

        log.info("Click on 'Create test plan' button");
    }

    @Step("Enter title of the test plan")
    public void enterTestPlanTitle(String testPlanTitle) {
        new Input(driver, "Title").write(testPlanTitle);
    }

    @Step("Enter description of the test plan")
    public void enterTestPlanDescription(String testPlanDescription) {
        new Input(driver, "Description").write(testPlanDescription);
    }

    @Step("Click on 'Add cases' button")
    public void addCasesButtonClick() {
        driver.findElement(ADD_CASES_BUTTON).click();

        log.info("Click on 'Add cases' button");
    }

    @Step("Click on checkbox")
    public void checkboxSelect() {
        driver.findElement(CHECKBOX).click();

        log.info("Click on checkbox");
    }

    @Step("Click on the button to add cases")
    public void addCasesDoneButton() {
        driver.findElement(ADD_CASES_DONE_BUTTON).click();

        log.info("Click on the button to add cases");
    }

    @Step("Click on 'Save test plan' button")
    public void savePlanButtonClick() {
        driver.findElement(SAVE_PLAN_BUTTON).click();

        log.info("Click on 'Save test plan' button");
    }

    /**
     * Создание базового Тест плана
     */
    @Step("Create base the test plan")
    public void createBaseTestPlan(String testPlanTitleForRun, String testPlanDescriptionForRun) {

        createPlanButtonClick();
        AllureUtils.takeScreenshot(driver);
        enterTestPlanTitle(testPlanTitleForRun);
        AllureUtils.takeScreenshot(driver);
        enterTestPlanDescription(testPlanDescriptionForRun);
        AllureUtils.takeScreenshot(driver);
        addCasesButtonClick();
        AllureUtils.takeScreenshot(driver);
        checkboxSelect();
        AllureUtils.takeScreenshot(driver);
        addCasesDoneButton();
        AllureUtils.takeScreenshot(driver);
        savePlanButtonClick();

        log.info(String.format("Creation of base test plan with title '%s' and description '%s'", testPlanTitleForRun, testPlanDescriptionForRun));
    }
}


