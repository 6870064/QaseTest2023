package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class MilestoneTest extends BaseTest {

    public static final String milestoneName = "Release 5.0";
    public static final String milestoneDescription = "Description of the Release 3.0";

    @Test(description = "Creation of new milestone")
    public void createNewMilestone() {

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        milestonePage.projectOpen();
        milestonePage.clickMilestoneSubmenu();
        milestonePage.clickCreateMilestoneButton();
        milestonePage.enterMilestoneName(milestoneName);
        milestonePage.enterMilestoneDescription(milestoneDescription);
        milestonePage.createNewMilestoneButtonClick();
        milestonePage.isPageOpened();
    }
}