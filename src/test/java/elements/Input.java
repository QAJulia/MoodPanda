package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Input {
    String label;
    String personalInfoLocator = "//label[contains(text(),'%s')]/ancestor::div[contains(@class,'form-group')]//input";

    public Input(String label) {
        this.label = label;
    }

    public void writePersonalInfo(String data) {
        $(By.xpath(String.format(personalInfoLocator, label))).clear();
        $(By.xpath(String.format(personalInfoLocator, label))).sendKeys(data);
    }
}
