package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import steps.AccountSteps;
import steps.LoginSteps;

@Log4j2
public class BaseTest {
    LoginSteps loginSteps;
    AccountSteps accountSteps;
    public final static String EMAIL = "";
    public final static String PASSWORD = "";

    @BeforeMethod
    public void setup() {
        Configuration.browser = "opera";
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
        loginSteps = new LoginSteps();
        accountSteps = new AccountSteps();
    }
}
