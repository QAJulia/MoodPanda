package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;

import static org.testng.Assert.assertEquals;

@Log4j2
public class LoginSteps {

    HomePage homePage;
    LoginPage loginPage;
    MainPage mainPage;

    public LoginSteps() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }

    @Step("Логин, используя корректные данные")
    public LoginSteps loginWithCorrectData(String email, String password) {
        homePage
                .openPage()
                .clickOnLoginButton()
                .login(email, password)
                .isPageOpened();
        return this;
    }

    @Step("Логин, используя некорректные данные")
    public LoginSteps loginWithIncorrectData(String email, String password) {
        String actualMessage = homePage
                .openPage()
                .clickOnLoginButton()
                .loginWithoutRedirect(email, password)
                .getErrorMessage();
        assertEquals(actualMessage, "Error: Could not find account. Forgot Password?");
        return this;
    }
}
