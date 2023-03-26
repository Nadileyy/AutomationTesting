package GlobalUse;

public class Constant {

    /*********************************************** CLOSE WINDOW **********************************************/
    public static final String closeSignInBtn ="//*[@id=\"logInModal\"]/div/div/div[3]/button[1]";
    public static final String closeSignUpBtn ="//*[@id=\"signInModal\"]/div/div/div[3]/button[1]";

    /************************************************** LOGIN **************************************************/
    public static final String signInXPath ="//*[@id=\"login2\"]";
    public static final String signInUserXpath ="//input[@id=\"loginusername\"]";
    public static final String signInPassXPath ="//input[@id=\"loginpassword\"]";
    public static final String signInBtnXPath ="//button[@onclick='logIn()']";

    /************************************************** SIGNUP **************************************************/
    public static final String signUpXPath = "//a[@id='signin2']";
    public static final String signUpUserXPath = "//*[@id=\"sign-username\"]";
    public static final String signUpPassXPath = "//input[@id='sign-password']";
    public static final String signUpBtnXPath = "//button[@onclick='register()']";

    /************************************************** INPUTS **************************************************/
    public static final String newSignUpUser = "hamza5050";
    public static final String password = "Test123";
    public static final String existSignUpUser = "Nadil908";
    public  static final String emptyInput = "";
    public  static final String emptyPassword = "";
    public static final String wrongUserName = "heba7070";


    /************************************************** ALERT ***********************************************/
    public static final String emptyAlert = "Please fill out Username and Password.";
    public static final String successfulRegistrationAlert = "Sign up successful.";
    public static final String existsUserAlert = "This user already exist.";
    public static final String nonExistsUser = "User does not exist.";
    public static final String wrongPassword = "Wrong password.";
    public static final String successfulAddition = "Product added";


    /************************************************ CATEGORY *********************************************/
    public static final String categoryXPath = "//*[@id='itemc']";
    public static final String itemsXPath = "//*[@class='hrefch']";


    /************************************************ CART *************************************************/
    public static final String addToCartBtn = "//*[@id=\"tbodyid\"]/div[2]/div/a";
    public static final String itemName = "//*[@class='name']";
    public static final String itemNameCartPage = "//*[@class='success']/td[2]";
    public static final String cartPageXPath = "//*[@id='cartur']";

    /************************************************ Delete ***********************************************/
    public static final String deleteXPath = "//*[@id=\"tbodyid\"]/tr/td[4]/a";
    public static final String itemsTableRows = "//tr[@class='success']";

    /*********************************************** Checkout **********************************************/

    public static final String placeOrderXPath = "//*[@id=\"page-wrapper\"]/div/div[2]/button";
    public static final String name = "//*[@id=\"name\"]";
    public static final String country = "//*[@id=\"country\"]";
    public static final String city = "//*[@id=\"city\"]";
    public static final String creditCard = "//*[@id=\"card\"]";
    public static final String month = "//*[@id=\"month\"]";
    public static final String year = "//*[@id=\"year\"]";


    /****************************************** Positive Checkout *****************************************/

    public static final String cardNameInput ="Nadil Mohammad";
    public static final String cardCountryInput ="Jordan";
    public static final String cardCityInput ="Irbid";
    public static final String cardNumberInput ="1234567812345678";
    public static final String cardMonthInput ="06";
    public static final String cardYearInput ="2026";
    public static final String purchaseXPath ="//*[@id=\"orderModal\"]/div/div/div[3]/button[2]";
    public static final String positiveCheckOut = "/html/body/div[10]/h2";
    ///html/body/div[10]/div[7]/div/button
    public static final String checkOutAlert = "Please fill out Name and Creditcard.";
}
