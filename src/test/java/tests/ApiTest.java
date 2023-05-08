package tests;

import adapters.ProjectAdapter;
import com.github.javafaker.Faker;
import models.Project;
import models.ResponseProject;
import models.ResponseStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ApiTest {

    Faker faker = new Faker();
    String code = faker.name().firstName().toUpperCase();

    @Test
    public void createProject() {
        Project project = Project.builder()
                .title("TEST "+ code)
                .code(code)
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void createpPojectWithDescription() {
        Project project = Project.builder()
                .title("TEST "+ code)
                .code(code)
                .description("Project test description")
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void createGroupProject() {
        Project project = Project.builder()
                .title("TEST "+ code)
                .code(code)
                .description("Project test description")
                .access("group")
                .group("YTRODFKDKSK" + code)
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void createPrivateProject() {
        Project project = Project.builder()
                .title("TEST "+ code)
                .code(code)
                .description("Private Project test description")
                .access("none")
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void createAllAccessProject() {
        Project project = Project.builder()
                .title("TEST "+ code)
                .code(code)
                .description("All Access Project test description")
                .access("all")
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void get() {
      ResponseProject project = new ProjectAdapter().getProject("TEST3");
      System.out.println(project);
    }
}