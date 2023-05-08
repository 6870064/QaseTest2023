package tests;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class ProjectTest extends BaseTest {

    Faker faker = new Faker();

    String publicProjectName = faker.date().toString() + " project" + " " + faker.date().toString();
    String privateProjectName = faker.date().toString() + " project" + " " + faker.date().toString();
    String publicDescription = faker.name().firstName().toUpperCase();
    String privateDescription = faker.name().firstName() + " " + faker.name().lastName();

    @Test(description = "Creation of the new public project")
    public void createNewPublicProject() {

        log.warn(String.format("Creation of new public project with the title '%s' and " +
                "description '%s'", publicProjectName, publicDescription));
        log.error(String.format("Error in creation of new public project with the title '%s' and " +
                "description '%s'", publicProjectName, publicDescription));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.createNewProjectButtonClick();
        assertTrue(projectPage.isPageOpened(), "Projects Page is not opened");
        projectPage.enterProjectName(publicProjectName);
        projectPage.enterDescription(publicDescription);
        projectPage.publicAccessRadioButtonClick();
        projectPage.createProjectButton();
    
        String errorText = String.format("New project titled %s is not created", publicProjectName);
        assertTrue(projectPage.isProjectCreated(), errorText);
    }

    @Test(description = "Creation of the new private project")
    public void createNewPrivateProject() {

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(loginFieldTitle, USER_LOGIN, passwordFieldTitle, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.createNewProjectButtonClick();
        assertTrue(projectPage.isPageOpened(), "Projects Page is not opened");
        projectPage.enterProjectName(privateProjectName);
        projectPage.enterDescription(privateDescription);
        projectPage.createProjectButton();
        String errorText = String.format("New project titled %s is not created", privateProjectName);
        assertTrue(projectPage.isProjectCreated(), errorText);
    }
}
