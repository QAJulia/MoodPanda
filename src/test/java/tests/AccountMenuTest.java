package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class AccountMenuTest extends BaseTest {

    @Test
    public void editAccountInfo(){
        loginSteps
                .loginWithCorrectData(System.getProperty("email"), System.getProperty("pass"));
        accountSteps
                .editAccountInfo("Julia1", "Other");
    }

    @Test
    public void logout(){
        loginSteps
                .loginWithCorrectData(System.getProperty("email"), System.getProperty("pass"));
        accountSteps
                .logout();
    }

    @Test
    public void changeAvatar(){
        loginSteps
                .loginWithCorrectData(System.getProperty("email"), System.getProperty("pass"));
        accountSteps
                .changeAvatarToNumber(2);
    }
}
