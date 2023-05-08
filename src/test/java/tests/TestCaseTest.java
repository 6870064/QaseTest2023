package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class TestCaseTest extends BaseTest {

    String testCaseTitleWithoutConditions = "The test case without picture and Conditions 555 Feb 08 2022";
    String testCaseTitleWithConditions = "The test case without picture with Conditions Feb 08 2022";
    String testCaseDescription = "Description of the new test case title";
    String testCaseStatus = "Draft";
    String testCaseSeverity = "Blocker";
    String testCasePriority = "High";
    String testCaseLayer = "E2E";
    String testCaseType = "Functional";
    String testCaseIsFlaky = "Yes";
    String testCaseBehavior = "Positive";
    String testCaseAutoStatus = "To be automated";
    String preConditions = "Pre-conditions of the test case";
    String postConditions = "Post-conditions of the test case";
    String stepAction = "Action of the step №";
    String stepInputData = "Step of the test case №";
    String stepExpectedResult = "Expected result of the test case №";
    int amountOfSteps = 10;
    String filePath = "src/test/resources/152360.jpeg";
    String fileName = "152360.jpeg";
    String confirmText = "CONFIRM";

    @Test(description = "Creation of the test case without adding conditions and the steps")
    public void createTestCaseWithoutConditionsAndSteps() {

        log.warn(String.format("Creation of new test case with the title '%s'", testCaseTitleWithoutConditions));
        log.error(String.format("Error in creation of new test case with the title '%s'", testCaseTitleWithoutConditions));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithoutConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test(description = "Creation of the test case with adding Pre-Conditions and 1 step")
    public void createTestCaseWithOneStep() {

        log.warn(String.format("Creation of new test case with the title '%s'", testCaseTitleWithConditions));
        log.error(String.format("Error in creation of new test case with the title '%s'", testCaseTitleWithConditions));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        testCasePage.enterPreConditions(preConditions);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        testCasePage.addStep(0, stepAction, stepInputData, stepExpectedResult);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test(description = "Creation of the test case with adding Pre-Conditions, Post-Conditions and 1 step")
    public void createTestCaseWithConditionsOneStep() {

        log.warn(String.format("Creation of new test case with the title '%s' and 1 step", testCaseTitleWithConditions));
        log.error(String.format("Error in creation of new test case with the title '%s' and 1 step", testCaseTitleWithConditions));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        testCasePage.enterPreConditions(preConditions);
        testCasePage.enterPostConditions(postConditions);
        testCasePage.addStep(0, stepAction, stepInputData, stepExpectedResult);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test(description = "Creation of the test case with adding Pre-Conditions, Post-Conditions and 10 steps without attachment")
    public void createTestCaseWithTenSteps() {

        log.warn(String.format("Creation of new test case with the title '%s' and 10 steps", testCaseTitleWithConditions));
        log.error(String.format("Error in creation of new test case with the title '%s' and 10 steps", testCaseTitleWithConditions));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        testCasePage.enterPreConditions(preConditions);
        testCasePage.enterPostConditions(postConditions);

        for (int b = 0; b < amountOfSteps; b++) { //Добавление 10 шагов в тест-кейс
            testCasePage.addStep(b, stepAction, stepInputData, stepExpectedResult);
        }
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test(description = "Creation of the test case with adding 1 step and attachment")
    public void createTestCaseWithFileAndOneStep() {

        log.warn(String.format("Creation of new test case with the title '%s', file of attachment is '%s' and 1 step", testCaseTitleWithoutConditions, fileName));
        log.error(String.format("Error in creation of new test case with the title '%s', file of attachment is '%s' and 1 step", testCaseTitleWithoutConditions, fileName));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithoutConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        defectPage.fileUpload(filePath);
        defectPage.checkTitleOfFileUploaded(fileName);
        testCasePage.addStep(0, stepAction, stepInputData, stepExpectedResult);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test(description = "Creation of the test case with adding 10 step and attachment")
    public void createTestCaseWithFileAndTenSteps() {

        log.warn(String.format("Creation of new test case with the title '%s', file of attachment is '%s' and 10 steps", testCaseTitleWithoutConditions, fileName));
        log.error(String.format("Error in creation of new test case with the title '%s', file of attachment is '%s' and 10 steps", testCaseTitleWithoutConditions, fileName));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithoutConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        defectPage.fileUpload(filePath);
        defectPage.checkTitleOfFileUploaded(fileName);
        for (int b = 0; b < amountOfSteps; b++) { //Добавление 10 шагов в тест-кейс
            testCasePage.addStep(b, stepAction, stepInputData, stepExpectedResult);
        }
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test(description = "Delete all cases on the project")
    public void deleteAllTestCases() {

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");

        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithoutConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");

        testCasePage.allCasesCheckBoxClick();
        testCasePage.deleteCasesButtonClick();
        testCasePage.enterTextConfirmDeleteField(confirmText);
        testCasePage.deleteCasesConfirmButtonClick();
        assertTrue(testCasePage.addFirstCaseButtonIsDisplayed(), "Repository page is not opened");
    }
}