package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class DefectTest extends BaseTest {

    Faker faker = new Faker();

    String defectTitle = "Test Bug title" + " " + faker.date().toString();
    String actualResult = "Bug №161 is exist - this is an actual result";
    String assigneeValueToClick = "Dmitry Vyacheslavov";
    String severityToCheck = "Critical";
    String filePath = "src/test/resources/152360.jpeg";
    String fileName = "152360.jpeg";
    String caseParamReporter = "Reporter";
    String caseParamAssignee = "Assignee";

    @Issue("170")
    @TmsLink("96")
    @Test(description = "Creation of new defect without attaching the file and milestone")
    public void createNewDefectWithoutAttachment() {

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.clickDefectsButton();
        defectPage.createNewDefectButton();
        defectPage.enterDefectTitle(defectTitle);
        defectPage.enterActualResult(actualResult);
        defectPage.selectSeverity(severityToCheck);
        defectPage.selectAssigneeValue(assigneeValueToClick);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }

    @Test(description = "Creation of new defect without attaching the file, milestone and Assignee")
    public void createNewDefectWithoutAssigneeAndAttachment() {


        log.warn(String.format("Creation new Defect with the title '%s', actual result '%s', severity to check '%s'", defectTitle, actualResult, severityToCheck));
        log.error(String.format("Creation new Defect with the title '%s', actual result '%s', severity to check '%s'", defectTitle, actualResult, severityToCheck));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.clickDefectsButton();
        defectPage.createNewDefectButton();
        defectPage.enterDefectTitle(defectTitle);
        defectPage.enterActualResult(actualResult);
        defectPage.selectSeverity(severityToCheck);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }

    @Test(description = "Creation of new defect with attaching the file and without milestone")
    public void createNewDefectWithAttachment() {

        log.warn(String.format("Creation new Defect with the title '%s', actual result '%s', title of the file uploaded '%s'",
                defectTitle, actualResult, fileName));
        log.error(String.format("Creation test case with the title '%s', actual result '%s', title of the file uploaded '%s'",
                defectTitle, actualResult, fileName));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.clickDefectsButton();
        defectPage.createNewDefectButton();
        defectPage.enterDefectTitle(defectTitle);
        defectPage.enterActualResult(actualResult);
        defectPage.selectSeverity(severityToCheck);
        defectPage.selectAssigneeValue(assigneeValueToClick);
        defectPage.fileUpload(filePath);
        defectPage.checkTitleOfFileUploaded(fileName);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
        defectPage.createdDefectOpen(defectTitle);

        assertEquals(defectPage.titleValueCheck(), defectTitle, "Title of the new bug created is not equal");
        assertEquals(defectPage.descriptionValueCheck(), actualResult, "Description of the new bug created is not equal");
        assertEquals(defectPage.caseSeverityValueCheck(), severityToCheck, "Severity of the new bug created is not equal");
        assertEquals(defectPage.caseParameterValueCheck(caseParamReporter), assigneeValueToClick, "The reporter of the new bug created is not equal");
        assertEquals(defectPage.caseParameterValueCheck(caseParamAssignee), assigneeValueToClick, "The assignee is not equal");
    }
}