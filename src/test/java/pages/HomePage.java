package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class HomePage {

    public static String URL = "https://moodpanda.com";
    public static String LOGIN_BUTTON = "//*[@id='bs-example-navbar-collapse-1']//*[contains(text(),'Login')]";

    public HomePage openPage(){
        open(URL);
        isPageOpened();
        return this;
    }

    public boolean isPageOpened(){
        $(By.xpath(LOGIN_BUTTON)).shouldBe(Condition.visible);
        return $(By.id(LOGIN_BUTTON)).exists();
    }

    public LoginPage clickOnLoginButton(){
        $(By.xpath(LOGIN_BUTTON)).click();
        return new LoginPage();
    }
}
