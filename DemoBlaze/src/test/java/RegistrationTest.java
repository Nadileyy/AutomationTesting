import GlobalUse.Constant;
import GlobalUse.RegLog;
import GlobalUse.TestSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import static GlobalUse.Constant.*;

public class RegistrationTest {
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
    @DisplayName("Positive Registration")
    public void positiveRegistration(){
        String testName = "Positive Registration";
        try{
            RegLog.signUpAllocate(signUpXPath);
            RegLog.userNameAndPasswordAllocate(signUpUserXPath,signUpPassXPath,signUpBtnXPath,newSignUpUser,password);

            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(successfulRegistrationAlert,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }
    @Test
    @DisplayName("Exists User Registration")
    public void existsRegistration(){
        String testName = "Exists User Registration";
        try{
            RegLog.signUpAllocate(signUpXPath);
            RegLog.userNameAndPasswordAllocate(signUpUserXPath,signUpPassXPath,signUpBtnXPath,existSignUpUser,password);
            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(existsUserAlert,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }
    @Test
    @DisplayName("Empty User Registration")
    public void emptyUserRegistration(){
        String testName = "Empty User Registration";
        try{
            RegLog.signUpAllocate(signUpXPath);
            RegLog.userNameAndPasswordAllocate(signUpUserXPath,signUpPassXPath,signUpBtnXPath, emptyInput,password);
            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(emptyAlert,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }
    @Test
    @DisplayName("Empty Password Registration")
    public void emptyPasswordRegistration(){
        String testName = "Empty Password Registration";
        try{
            RegLog.signUpAllocate(signUpXPath);
            RegLog.userNameAndPasswordAllocate(signUpUserXPath,signUpPassXPath,signUpBtnXPath,newSignUpUser,emptyPassword);
            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(Constant.emptyAlert,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }
    @Test
    @DisplayName("Empty Registration")
    public void emptyRegistration(){
        String testName = "Empty Registration";
        try{
            RegLog.signUpAllocate(signUpXPath);
            RegLog.userNameAndPasswordAllocate(signUpUserXPath,signUpPassXPath,signUpBtnXPath, emptyInput,emptyPassword);
            String alertText = TestSetUp.alertText();
            TestSetUp.verificationAlert(emptyAlert,alertText,testName);
        } catch (Exception exception){
            System.out.println(testName+" test failed.\n" +
                    "An Exception occurred: "+exception);
        }
    }

    /*************************************************** After **************************************************/
    @AfterEach
    public void tearDown(){
        TestSetUp.acceptAlert();
        TestSetUp.quitDriver();
    }
}
