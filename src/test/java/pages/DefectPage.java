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
public class DefectPage extends BasePage{

    public static final By DEFECTS_SUBMENU = By.id("menu-link-test-defects");
    public static final By CREATE_NEW_DEFECT_BUTTON = By.xpath("//*[text()='Create new defect']");
    public static final By CREATE_DEFECT_BUTTON = By.xpath("//button[@class='btn btn-primary me-3 save-button']");

    //TODO make TITLE_OF_DEFECT_CREATED locator more generic
    String TITLE_OF_DEFECT_CREATED = "//*[contains(text(),'%s')]";
    String TITLE_OF_DEFECT_ON_PAGE = "//div[@class='col-lg-12']/h1";
    String DESCRIPTION_OF_DEFECT_CREATED = "//p[@class='defect-result-header' and contains (text(), 'Description')]/../div/div";
    String CASE_PARAM_LOCATOR = "//div[@class='case-param-title' and contains (text(), '%s')]/../div/div/span";
    String SEVERITY_PARAM_LOCATOR = "//i[contains(@class,'fa-angle-double-up')]/..";

    public DefectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return BasePage.isElementExist(CREATE_NEW_DEFECT_BUTTON);
    }

    public void clickDefectsButton() {

        driver.findElement(DEFECTS_SUBMENU).click();
        log.info("Click on the Defect button");
    }

    /**
     * Click on the button for creation new defect
     */
    public void createNewDefectButton() {

        driver.findElement(CREATE_NEW_DEFECT_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        log.info("Click on the button for creation new defect");
    }

    public void enterDefectTitle(String defectTitle) {

        new Input(driver, "Defect title").write(defectTitle);
        AllureUtils.takeScreenshot(driver);
    }

    public void enterActualResult(String actualResult) {
        new Input(driver, "Actual result").write(actualResult);
    }

    @Step("Choose Severity of the Defect created")
    public void selectSeverity(String severityValue) {

        new Dropdown(driver, "Severity", "Normal", severityValue).dropDownClick();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Choose Assignee for the Defect created")
    public void selectAssigneeValue(String assigneeValueToClick) {
        new CustomDropdown(driver, "Assignee", "Unassigned", assigneeValueToClick).dropDownClick();
        AllureUtils.takeScreenshot(driver);
    }

    /**
     * Allows saving defect
     */
    @Step("Click on 'Create Defect' button")
    public void createDefectButtonClick() {

        driver.findElement(CREATE_DEFECT_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        log.info("Click on 'Create Defect' button");
    }

    /**
     * Метод для открытия созданного баг репорта
     */

    public void createdDefectOpen(String titleOfDefect) {

        driver.findElement(By.xpath(String.format(TITLE_OF_DEFECT_CREATED, titleOfDefect))).click();
        AllureUtils.takeScreenshot(driver);
        log.info("Open defect created");
    }

    /**
     * Метод для проверки правильности заполнения параметра Title в созданном баг репорте
     */
    public String titleValueCheck() {

        String titleCreatedValue = driver.findElement(By.xpath(String.format(TITLE_OF_DEFECT_ON_PAGE))).getText();
        return titleCreatedValue;
    }

    /**
     * Метод для проверки правильности заполнения параметра Description в созданном баг репорте
     */
    public String descriptionValueCheck() {

        String bugCreatedValue = driver.findElement(By.xpath(String.format(DESCRIPTION_OF_DEFECT_CREATED))).getText();
        return bugCreatedValue;
    }

    /**
     * Метод для проверки правильности заполнения параметров Reporter и Assignee в созданном баг репорте
     */
    public String caseParameterValueCheck(String reporterValue) {

        String bugCreatedValue = driver.findElement(By.xpath(String.format(CASE_PARAM_LOCATOR, reporterValue))).getText();
        return bugCreatedValue;
    }

    /**
     * Метод для проверки правильности заполнения параметра Severity в созданном баг репорте
     */
    public String caseSeverityValueCheck() {

        String bugSeverityValue = driver.findElement(By.xpath(SEVERITY_PARAM_LOCATOR)).getText();
        return bugSeverityValue;
    }
}
