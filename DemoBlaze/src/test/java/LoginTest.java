import GlobalUse.Constant;
import GlobalUse.RegLog;
import GlobalUse.TestSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import static GlobalUse.Constant.*;

public class LoginTest {
    /*************************************************** Before **************************************************/
    @BeforeAll
    public static void SetUpMethod(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void SetUp(){
        TestSetUp.setUp();
    }

    /*************************************************** Tests ***************************************************/
    @Test
    @DisplayName("Wrong Username Login")
    public void wrongUserNameLogin(){
        String testName = "Wrong Username Login";
        try{
            RegLog.signUpAllocate(signInXPath);
            RegLog.userNameAndPasswordAllocate(signInUserXpath, signInPassXPath,signInBtnXPath
                    ,wrongUserName,password);

            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(nonExistsUser,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }
    @Test
    @DisplayName("Wrong Password Login")
    public void wrongPasswordLogin(){
        String testName = "Wrong Password Login";
        try{
            RegLog.signUpAllocate(signInXPath);
            RegLog.userNameAndPasswordAllocate(signInUserXpath, signInPassXPath,signInBtnXPath
                    ,newSignUpUser,wrongPassword);

            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(wrongPassword,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }
    @Test
    @DisplayName("Empty Password Login")
    public void emptyPasswordLogin(){
        String testName = "Empty Password Login";
        try{
            RegLog.signUpAllocate(signInXPath);
            RegLog.userNameAndPasswordAllocate(signInUserXpath,signInPassXPath,signInBtnXPath,newSignUpUser,emptyPassword);

            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(emptyAlert,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }
    @Test
    @DisplayName("Empty Username Login")
    public void emptyUseNameLogin(){
        String testName = "Empty Username Login";
        try{
            RegLog.signUpAllocate(signInXPath);
            RegLog.userNameAndPasswordAllocate(signInUserXpath,signInPassXPath,signInBtnXPath, emptyInput,password);

            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(emptyAlert,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }
    @Test
    @DisplayName("Empty Login")
    public void emptyLogin(){
        String testName = "Empty Login";
        try{
            RegLog.signUpAllocate(signInXPath);
            RegLog.userNameAndPasswordAllocate(signInUserXpath,signInPassXPath,signInBtnXPath, emptyInput,emptyPassword);

            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(Constant.emptyAlert,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }
    /*************************************************** After **************************************************/
    @AfterEach
    public void tearDown(){
        TestSetUp.acceptAlert();
        RegLog.closeWindow(Constant.closeSignInBtn);
        TestSetUp.quitDriver();
    }
}
