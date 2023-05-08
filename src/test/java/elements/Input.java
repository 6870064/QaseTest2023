package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {

    WebDriver driver;
    String label;
    String INPUT_VALUE_LOCATOR = "//label[text()='%s']/parent::div//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {

        log.debug(String.format("Writing text '%s' into input with label %s", text, label));

        driver.findElement(By.xpath(String.format(INPUT_VALUE_LOCATOR, label))).sendKeys(text);
    }
}
