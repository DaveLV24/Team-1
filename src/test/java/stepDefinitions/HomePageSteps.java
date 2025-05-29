//package stepDefinitions;
//
//import hooks.Hooks;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import pageObjects.HomePage;
//import pageObjects.LoginPage;
//
//public class HomePageSteps {
//    private final HomePage homePage;
//    private final LoginPage loginPage;
//
//    public HomePageSteps() {
//        this.homePage = new HomePage(Hooks.driver);
//        this.loginPage = new LoginPage(Hooks.driver);
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
//        loginPage.login("test@example.com", "password123");
//        Assert.assertTrue(homePage.isUserLoggedIn());
//    }
//}