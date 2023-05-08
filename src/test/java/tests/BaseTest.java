package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.WebDriver_Initializer;
import tests.base.TestListener;
import utils.PropertyReader;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {

    public static PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    public static WebDriver_Initializer webDriverInitializer = WebDriver_Initializer.getInstance();
    public static WebDriver driver = webDriverInitializer.driverInitialization();
    public static String BASE_URL = propertyReader.getPropertyValueByKey("base.url");
    public String loginFieldTitle = "Email";
    public String passwordFieldTitle = "Password";
    protected final String USER_LOGIN = System.getProperty("username", propertyReader.getPropertyValueByKey("username"));
    protected final String USER_PASSWORD = System.getProperty("username", propertyReader.getPropertyValueByKey("password"));

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    ProjectPage projectPage = new ProjectPage(driver);
    DefectPage defectPage = new DefectPage(driver);
    MilestonePage milestonePage = new MilestonePage(driver);
    TestCasePage testCasePage = new TestCasePage(driver);
    TestPlanPage testPlanPage = new TestPlanPage(driver);
    TestRunPage testRunPage = new TestRunPage(driver);

    @Parameters({"browser"})
    @BeforeMethod()
    public void setUp(@Optional("chrome") String browser) {
//        driver = webDriverInitializer.driverInitialization();
    }

    @AfterMethod()
    public void tearDown() {
        webDriverInitializer.closeDriver();
    }
}
