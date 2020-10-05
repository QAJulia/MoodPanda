package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {

    public static String URL = "https://moodpanda.com/Login/";
    public static String EMAIL_FIELD = "ContentPlaceHolderContent_TextBoxEmail";
    public static String PASSWORD_FIELD = "ContentPlaceHolderContent_TextBoxPassword";
    public static String LOGIN_BUTTON = "ContentPlaceHolderContent_ButtonLogin";
    public static String ERROR_MESSAGE = ".alert-danger";

    public LoginPage openPage() {
        open(URL);
        return this;
    }

    public boolean isPageOpened() {
        $(By.id(EMAIL_FIELD)).shouldBe(Condition.visible);
        return $(By.id(EMAIL_FIELD)).exists();
    }

    public MainPage login(String email, String password) {
        $(By.id(EMAIL_FIELD)).sendKeys(email);
        $(By.id(PASSWORD_FIELD)).sendKeys(password);
        log.info("Email: " + email + " Password: " + password);
        $(By.id(LOGIN_BUTTON)).click();
        return new MainPage();
    }

    public LoginPage loginWithoutRedirect(String email, String password) {
        $(By.id(EMAIL_FIELD)).sendKeys(email);
        $(By.id(PASSWORD_FIELD)).sendKeys(password);
        log.info("Email: " + email + " Password: " + password);
        $(By.id(LOGIN_BUTTON)).click();
        return new LoginPage();
    }

    public String getErrorMessage() {
        log.info($(ERROR_MESSAGE).getText());
        return $(ERROR_MESSAGE).getText();
    }
}
