package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

import static tests.BaseTest.driver;

@Log4j2
public class MilestonePage extends BasePage {

    public static final By MILESTONES_SUBMENU = By.xpath("//*[text()='Milestones']");
    public static final By CREATE_MILESTONE_BUTTON = By.id("createButton");
    public static final By CREATE_NEW_MILESTONE_BUTTON = By.xpath("//button[@class='btn btn-primary me-3 save-button']");

    public MilestonePage(WebDriver driver) {
        super(driver);
    }

    public void projectOpen() {
        driver.get(ProjectPage.PROJECT_URL);
    }

    @Override
    public boolean isPageOpened() {
        return BasePage.isElementExist(CREATE_MILESTONE_BUTTON);
    }

    @Step("Click on milestone submenu")
    public void clickMilestoneSubmenu() {

        driver.findElement(MILESTONES_SUBMENU).click();
        log.warn("Click on milestone submenu");
        log.error("Click on milestone submenu");
    }

    @Step("Click on the button to create new milestone")
    public void clickCreateMilestoneButton() {

        driver.findElement(CREATE_MILESTONE_BUTTON).click();
        log.warn("Click on the button to create new milestone");
        log.error("Click on the button to create new milestone");
    }

    @Step("Enter the title for the milestone")
    public void enterMilestoneName(String releaseTitle) {

        new Input(driver, "Milestone name").write(releaseTitle);
    }

    @Step("Enter the description for the milestone")
    public void enterMilestoneDescription(String releaseDescription) {

        new Input(driver, "Description").write(releaseDescription);
    }

    @Step("Click on 'Create milestone' button")
    public void createNewMilestoneButtonClick() {

        driver.findElement(CREATE_NEW_MILESTONE_BUTTON).click();
        log.info("Click on 'Create milestone' button");
    }

    @Step("Create base milestone")
    public void createBaseMilestone(String milestoneForTestRunName, String milestoneDescription) {

        log.info(String.format("Creation of base base milestone with the title '%s' and description '%s'",milestoneForTestRunName, milestoneDescription));

        clickMilestoneSubmenu();
        AllureUtils.takeScreenshot(driver);
        clickCreateMilestoneButton();
        AllureUtils.takeScreenshot(driver);
        enterMilestoneName(milestoneForTestRunName);
        AllureUtils.takeScreenshot(driver);
        enterMilestoneDescription(milestoneDescription);
        AllureUtils.takeScreenshot(driver);
        createNewMilestoneButtonClick();
        AllureUtils.takeScreenshot(driver);
        isPageOpened();
    }
}
