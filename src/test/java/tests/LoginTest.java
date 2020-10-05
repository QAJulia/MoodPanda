package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class LoginTest extends BaseTest {

    @Test
    public void correctLogin() {
        loginSteps
                .loginWithCorrectData(System.getProperty("email"), System.getProperty("pass"));
    }

    @Test
    public void emptyEmailField() {
        loginSteps
                .loginWithIncorrectData("", System.getProperty("pass"));
    }
}
