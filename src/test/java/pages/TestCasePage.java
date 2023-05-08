package pages;

import elements.CustomInput;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AllureUtils;

import static tests.BaseTest.driver;

@Log4j2
public class TestCasePage extends BasePage {

    public static final By CREATE_FIRST_CASE_BUTTON = By.xpath("//*[text()='Create new case']");
    public static final By CREATE_CASE_BUTTON = By.id("create-case-button");
    public static final By ADD_STEP_BUTTON = By.id("add-step");
    public static final By SAVE_BUTTON = By.id("save-case");
    public static final By ALL_CASES_WITHOUT_SUITE_CHECKBOX = By.xpath("//label[@class='style_checkbox-1sXFN style_checkbox-37xEi style_inHeader-1Loef']/input");
    public static final By DELETE_CASES_BUTTON = By.xpath("//button[contains(text(),'Delete')]");
    public static final By CONFIRM_DELETE_FIELD = By.xpath("//input[@class='form-control'][@name='confirm']");
    public static final By DELETE_CASES_CONFIRM_BUTTON = By.xpath("//button[text()='Delete']");

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public boolean addFirstCaseButtonIsDisplayed() {
        return BasePage.isElementExist(CREATE_FIRST_CASE_BUTTON);
    }

    public boolean addCaseButtonIsDisplayed() {
        return BasePage.isElementExist(CREATE_CASE_BUTTON);
    }

    @Step("Click on the button 'Create test case'")
    public void createTestCaseButtonClick() {
        driver.findElement(CREATE_CASE_BUTTON).click();
        log.info("Click on the button 'Create test case'");
    }

    @Step("Enter title of the test case")
    public void enterTestCaseTitle(String testCaseTitle) {

        new Input(driver, "Title").write(testCaseTitle);
    }

    @Step("Select status of test case'")
    public void selectStatus(String testCaseStatus) {

        new Dropdown(driver, "Status", "Actual", testCaseStatus).dropDownClick();
    }

    @Step("Enter of the test case description")
    public void enterDescription(String testCaseDescription) {

        new Input(driver, "Description").write(testCaseDescription);
    }

    @Step("Select severity of the test case")
    public void selectSeverity(String testCaseSeverity) {

        new Dropdown(driver, "Severity", "Normal", testCaseSeverity).dropDownClick();
    }

    @Step("Select priority of the test case")
    public void selectPriority(String testCasePriority) {

        new Dropdown(driver, "Priority", "Not set", testCasePriority).dropDownClick();
    }

    @Step("Select type of the test case")
    public void selectType(String testCaseType) {
        new Dropdown(driver, "Type", "Other", testCaseType).dropDownClick();
    }

    @Step("Select layer of the test case")
    public void selectLayer(String testCaseLayer) {
        new Dropdown(driver, "Layer", "Unknown", testCaseLayer).dropDownClick();
    }

    @Step("Select staus of test case 'isFlaky'")
    public void selectIsFlaky(String testCaseIsFlaky) {
        new Dropdown(driver, "Is Flaky", "No", testCaseIsFlaky).dropDownClick();
    }

    @Step("Select behavior of the test case")
    public void selectBehavior(String testCaseBehavior) {
        new Dropdown(driver, "Behavior", "Not set", testCaseBehavior).dropDownClick();
    }

    @Step("Select automation status of the test case")
    public void selectAutomationStatus(String testCaseAutoStatus) {
        new Dropdown(driver, "Automation status", "Not automated", testCaseAutoStatus).dropDownClick();
    }

    @Step("Enter pre-conditions of the test case")
    public void enterPreConditions(String preConditions) {
        new Input(driver, "Pre-conditions").write(preConditions);
    }

    @Step("Enter post-conditions of the test case")
    public void enterPostConditions(String postConditions) {
        new Input(driver, "Post-conditions").write(postConditions);
    }

    @Step("Enter preconditions of the test case")
    public void saveButtonClick() {
        driver.findElement(SAVE_BUTTON).click();

        log.info("Enter preconditions of the test case");
    }

    @Step("Click on the checkbox to select all test cases")
    public void allCasesCheckBoxClick() {
        driver.findElement(ALL_CASES_WITHOUT_SUITE_CHECKBOX).click();

        log.info("Click on the checkbox to select all test cases");
    }

    @Step("Click on the button to delete all test cases")
    public void deleteCasesButtonClick() {
        driver.findElement(DELETE_CASES_BUTTON).click();

        log.info("Click on the button to delete all test cases");
    }

    @Step("Enter the text to confirm removal of all test cases")
    public void enterTextConfirmDeleteField(String text) {
        driver.findElement(CONFIRM_DELETE_FIELD).sendKeys(text);

        log.info("Enter the text to confirm removal of all test cases");
    }

    @Step("Click on the button to confirm deletion of all test cases")
    public void deleteCasesConfirmButtonClick() {
        driver.findElement(DELETE_CASES_CONFIRM_BUTTON).click();

        log.info("Click on the button to confirm deletion of all test cases");
    }


    /**
     * обобщенный метод, который принимает много параметров и переиспользует все эти мелкие
     */

    @Step("Create the base test case")
    public void createBaseTestCase(String testCaseTitle, String testCaseDescription, String testCaseStatus, String testCaseSeverity,
                                   String testCasePriority, String testCaseType, String testCaseLayer, String testCaseIsFlaky,
                                   String testCaseBehavior, String testCaseAutoStatus) {

        createTestCaseButtonClick();
        AllureUtils.takeScreenshot(driver);
        enterTestCaseTitle(testCaseTitle);
        AllureUtils.takeScreenshot(driver);
        enterDescription(testCaseDescription);
        AllureUtils.takeScreenshot(driver);
        selectStatus(testCaseStatus);
        AllureUtils.takeScreenshot(driver);
        selectSeverity(testCaseSeverity);
        AllureUtils.takeScreenshot(driver);
        selectPriority(testCasePriority);
        AllureUtils.takeScreenshot(driver);
        selectType(testCaseType);
        AllureUtils.takeScreenshot(driver);
        selectLayer(testCaseLayer);
        AllureUtils.takeScreenshot(driver);
        selectIsFlaky(testCaseIsFlaky);
        AllureUtils.takeScreenshot(driver);
        selectBehavior(testCaseBehavior);
        AllureUtils.takeScreenshot(driver);
        selectAutomationStatus(testCaseAutoStatus);
        AllureUtils.takeScreenshot(driver);
        saveButtonClick();

        log.info("Creation of the base test case");
    }

    @Step("Adding the step of test case")
    public void addStep(int i, String action, String inputData, String expectedResult) {  //Метод по добавлению шагов в тест-кейс испольуя CustomInput

        WebElement element = driver.findElement(ADD_STEP_BUTTON); //scrolling
        BasePage.jsExecutor.scrollToElement(element);
        BasePage.jsExecutor.clickOnElement(element);

        int a = i + 1;
        new CustomInput(driver, "action", Integer.toString(i)).write(action + a);
        AllureUtils.takeScreenshot(driver);
        new CustomInput(driver, "data", Integer.toString(i)).write(inputData + a);
        new CustomInput(driver, "expected_result", Integer.toString(i)).write(expectedResult + a);

        log.info("Adding the step of test case");
    }
}
