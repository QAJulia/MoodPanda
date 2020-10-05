package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class MainPage {
    public static String ACCOUNT = "//li[@id='Settings']/a[@class='dropdown-toggle']";
    //public static String ME = "//li[@id='LIMe']";
    //public static String COMMUNITY = "//li[@id='LIWorld']";
    public static String UPDATE_MOOD = "LinkUpdate";
    public static String EDIT_PROFILE = "//*[contains(text(),'Edit')]";
    public static String CHANGE_AVATAR = "//*[contains(text(),'Avatar')]";
    public static String LOGOUT = "//*[@id='LinkLogout']/a/span";
    public static String URL = "https://moodpanda.com/Feed/";

    public MainPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    public boolean isPageOpened() {
        $(By.id(UPDATE_MOOD)).shouldBe(Condition.visible);
        return $(By.id(UPDATE_MOOD)).exists();
    }

    public AccountPage goToEditProfileInfoPage() {
        $(By.xpath(ACCOUNT)).click();
        $(By.xpath(EDIT_PROFILE)).click();
        return new AccountPage();
    }

    public AvatarPage goToChangeAvatarPage() {
        $(By.xpath(ACCOUNT)).click();
        $(By.xpath(CHANGE_AVATAR)).click();
        return new AvatarPage();
    }

    public HomePage logout() {
        $(By.xpath(ACCOUNT)).click();
        $(By.xpath(LOGOUT)).click();
        return new HomePage();
    }
}
