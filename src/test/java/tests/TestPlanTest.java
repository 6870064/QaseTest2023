package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class TestPlanTest extends BaseTest {

    String testCaseTitleWithoutConditions = "The test case without picture and Conditions Jan 25 2022";
    String testCaseTitle = "Base test case";
    String testCaseDescription = "Description of the new test case title";
    String testCaseStatus = "Draft";
    String testCaseSeverity = "Blocker";
    String testCasePriority = "High";
    String testCaseLayer = "E2E";
    String testCaseType = "Functional";
    String testCaseIsFlaky = "Yes";
    String testCaseBehavior = "Positive";
    String testCaseAutoStatus = "To be automated";
    String testPlanTitle = "Test plan for regression testing #1";
    String testPlanDescription = "Description for regression testing Test plan for #1";

    @Test(description = "Creation test plan")
    public void createTestPlan() {

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testPlanPage.projectOpen();

        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");

        testCasePage.createBaseTestCase(testCaseTitle, testCaseDescription, testCaseStatus, testCaseSeverity, testCasePriority,
                testCaseType, testCaseLayer, testCaseIsFlaky, testCaseBehavior, testCaseAutoStatus);

        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");

        testPlanPage.testPlansButtonClick();
        assertTrue(testPlanPage.createPlanButtonIsDisplayed(), "Test plans page is not opened");
        testPlanPage.createPlanButtonClick();
        testPlanPage.enterTestPlanTitle(testPlanTitle);
        testPlanPage.enterTestPlanDescription(testPlanDescription);
        testPlanPage.addCasesButtonClick();
        testPlanPage.checkboxSelect();
        testPlanPage.addCasesDoneButton();
        testPlanPage.savePlanButtonClick();
        assertTrue(testPlanPage.createPlanButtonIsDisplayed(), "Test plans page is not opened");
    }
}
