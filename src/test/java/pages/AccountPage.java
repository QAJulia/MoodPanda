package pages;

import com.codeborne.selenide.Condition;
import elements.Input;
import elements.Select;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
//TODO Сделать больше полей для заполнения

@Log4j2
public class AccountPage {
    public static String URL = "https://moodpanda.com/Account/";
    public static String INPUT_NAME_FIELD = "ContentPlaceHolderContent_TextBoxFirstname";
    public static String UPDATE_BUTTON = "ContentPlaceHolderContent_ButtonSave";
    public static String SUCCESS_MESSAGE = "ContentPlaceHolderContent_MessageSuccess";

    public AccountPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public boolean isPageOpened() {
        $(By.id(INPUT_NAME_FIELD)).shouldBe(Condition.visible);
        return $(By.id(INPUT_NAME_FIELD)).exists();
    }

    public AccountPage editInfo(String firstName, String gender) {
        new Input("First Name").writePersonalInfo(firstName);
        new Select("Gender").selectInPersonalInfo(gender);
        log.info("First Name: " + firstName + " Gender: " + gender);
        $(By.id(UPDATE_BUTTON)).click();
        return this;
    }

    public String getSuccessMessage() {
        return $(By.id(SUCCESS_MESSAGE)).getText();
    }
}
