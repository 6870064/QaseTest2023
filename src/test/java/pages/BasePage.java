package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JSExecutor;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static tests.BaseTest.driver;

@Log4j2
public abstract class BasePage {
    public static final By ADD_ATTACHMENT_BUTTON = By.xpath("//button[text()=' Add attachment']");
    public static final By DROP_FILES_AREA = By.xpath("//input[@class='dz-hidden-input']");
    public static final By UPLOADED_FILE = By.xpath("//div//p[@class='suitecase-attachment-filename']");
    public static JSExecutor jsExecutor;

    public BasePage(WebDriver driver) {
        jsExecutor = new JSExecutor(driver);
    }

    public abstract boolean isPageOpened();

    public void projectOpen() {
        driver.get(ProjectPage.PROJECT_URL);
    }

    public static boolean isElementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Step("Upload File as attachment")
    public void fileUpload(String filePath) {
        log.info("Upload File with the path " + filePath + " as attachment");
        jsExecutor.scrollToElement(driver.findElement(ADD_ATTACHMENT_BUTTON));
        jsExecutor.clickOnElement(driver.findElement(ADD_ATTACHMENT_BUTTON));
        File file = new File(filePath);
        WebElement input_field = driver.findElement(DROP_FILES_AREA);
        input_field.sendKeys(file.getAbsolutePath());
        driver.findElement(DROP_FILES_AREA).sendKeys(file.getAbsolutePath());
    }

    public void checkTitleOfFileUploaded(String fileName) {
        log.info("check upload of the file titled " + fileName);
        String titleOfFile = driver.findElement(UPLOADED_FILE).getAttribute("innerText");
        assertEquals(titleOfFile, fileName, "Title of the uploaded file is not equal"); //Проверить, что имя файла
        // на странице совпадает с именем загруженного файла
    }
}
