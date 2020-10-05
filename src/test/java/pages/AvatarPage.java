package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
public class AvatarPage {
    public static String URL = "https://moodpanda.com/Account/Avatar/";
    public static String AVA_LIST = ".col-lg-12";
    public static String IMAGES = "//input[@type='image']";
    public static String SUCCESS_MESSAGE = "ContentPlaceHolderContent_MessageSuccess";


    public AvatarPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public boolean isPageOpened() {
        $(AVA_LIST).shouldBe(Condition.visible);
        return $(By.id(AVA_LIST)).exists();
    }

    public AvatarPage changeAvatar(int avatar) {
        $$(By.xpath(IMAGES)).get(avatar).click();
        log.info("Количество аватаров: " + $$(By.xpath(IMAGES)).size());
        return this;
    }

    public String getSuccessMessage() {
        log.info($(By.id(SUCCESS_MESSAGE)).getText());
        return $(By.id(SUCCESS_MESSAGE)).getText();
    }

}
