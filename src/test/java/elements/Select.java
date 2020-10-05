package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Select {
    String label;
    String personalInfoLocator = "//label[contains(text(), 'Gender')]/ancestor::div[@class = 'form-group']//select";
    String optionLocator = "//option[@value='%s']";

    public Select(String label) {
        this.label = label;
    }

    public void selectInPersonalInfo(String option){
        $(By.xpath(String.format(personalInfoLocator,label))).click();
        $(By.xpath(String.format(optionLocator, option))).click();
    }
}
