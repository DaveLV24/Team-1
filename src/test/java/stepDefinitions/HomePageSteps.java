//package stepDefinitions;
//
//import hooks.Hooks;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import pageObjects.HomePage_AA;
//import pageObjects.LoginPage_AA;
//
//public class HomePageSteps {
//    private final HomePage_AA homePage;
//    private final LoginPage_AA loginPageAA;
//
//    public HomePageSteps() {
//        this.homePage = new HomePage_AA(Hooks.driver);
//        this.loginPageAA = new LoginPage_AA(Hooks.driver);
//    }
//
//    @Given("I am on the homepage")
//    public void navigateToHomepage() {
//        homePage.navigateToHomePage();
//    }
//
//    @When("I search for {string}")
//    public void searchForProduct(String productName) {
//        homePage.searchForProduct(productName);
//    }
//
//    @When("I login from homepage")
//    public void loginFromHomepage() {
//        homePage.clickLoginLink();
//        loginPageAA.login("test@example.com", "password123");
//        Assert.assertTrue(homePage.isUserLoggedIn());
//    }
//}