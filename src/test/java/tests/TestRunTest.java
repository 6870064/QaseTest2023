package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static tests.MilestoneTest.milestoneDescription;

@Log4j2
public class TestRunTest extends BaseTest {

    String testCaseTitle = "Base test case";
    String testCaseDescription = "Description of the new test case title";
    String testCaseStatus = "Draft";
    String testCaseSeverity = "Critical";
    String testCasePriority = "High";
    String testCaseLayer = "E2E";
    String testCaseType = "Functional";
    String testCaseIsFlaky = "Yes";
    String testCaseBehavior = "Positive";
    String testCaseAutoStatus = "To be automated";
    String testRunTitle = "Test run 555 title";
    String testRunDescription = "Test run 555 Description";
    String testPlanTitleForRun = "Test plan 555 for regression testing #1";
    String testPlanDescriptionForRun = "Test plan 555 Description";
    String milestoneForTestRunName = "Release 55.0";
    String assigneeValueToClick = "Dmitry Vyacheslavov";

    @Test(description = "Creation of the test run")
    public void createTestRun() {

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testPlanPage.projectOpen();

        // создание testcase для test run
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createBaseTestCase(testCaseTitle, testCaseDescription, testCaseStatus, testCaseSeverity, testCasePriority,
                testCaseType, testCaseLayer, testCaseIsFlaky, testCaseBehavior, testCaseAutoStatus);
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");

        // создание milestone для test run
        milestonePage.createBaseMilestone(milestoneForTestRunName, milestoneDescription);

        //создание test plan для test run
        testPlanPage.testPlansButtonClick();
        assertTrue(testPlanPage.createPlanButtonIsDisplayed(), "Test plans page is not opened");
        testPlanPage.createBaseTestPlan(testPlanTitleForRun, testPlanDescriptionForRun);
        assertTrue(testPlanPage.createPlanButtonIsDisplayed(), "Test plans page is not opened");

        //создание test run
        testRunPage.testRunsSubmenuClick();
        assertTrue(testRunPage.startNewTestRunButtonIsDisplayed(), "Test run page is not opened");
        testRunPage.setStartNewTestRunButtonClick();
        testRunPage.enterRunTitle(testRunTitle);
        testRunPage.enterTestRunDescription(testRunDescription);
        testRunPage.assigneeSelect(assigneeValueToClick);
        testRunPage.setAddCasesButtonClick();
        testRunPage.checkboxClick();
        testRunPage.doneButtonClick();
        testRunPage.startRunButtonClick();
        assertTrue(testRunPage.startNewTestRunButtonIsDisplayed(), "Test run page is not opened");
    }
}
