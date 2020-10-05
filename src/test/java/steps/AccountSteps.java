package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.AccountPage;
import pages.AvatarPage;
import pages.HomePage;
import pages.MainPage;

import static org.testng.Assert.assertEquals;

@Log4j2
public class AccountSteps {

    MainPage mainPage;
    AccountPage accountPage;
    HomePage homePage;
    AvatarPage avatarPage;

    public AccountSteps() {

        mainPage = new MainPage();
        accountPage = new AccountPage();
        homePage = new HomePage();
        avatarPage = new AvatarPage();
    }

    @Step("Изменение информации о профиле")
    public AccountSteps editAccountInfo(String firstName, String gender) {
        String actualResult = mainPage
                .goToEditProfileInfoPage()
                .editInfo(firstName, gender)
                .getSuccessMessage();
        assertEquals(actualResult, "×\n" +
                "Success! Your changes were saved");
        return this;
    }

    @Step("Выход с аккаунта")
    public AccountSteps logout() {
        mainPage
                .logout()
                .isPageOpened();
        return this;
    }

    @Step("Изменение аватара профиля")
    public AccountSteps changeAvatarToNumber(int avatar){
        mainPage
                .goToChangeAvatarPage()
                .isPageOpened();
        String actualResult = avatarPage
                .changeAvatar(avatar)
                .getSuccessMessage();
        assertEquals(actualResult, "×\n" +
                "Success! Your changes were saved");
        return this;
    }
}
