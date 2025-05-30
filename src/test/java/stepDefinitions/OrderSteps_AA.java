package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.OrdersPage_AA;

public class OrderSteps_AA {
    private WebDriver driver = Hooks.driver;
    private OrdersPage_AA ordersPageAA;

//    @Given("I am logged in")
//    public void i_am_logged_in() {
//        // Inherited from CommonSteps_AA
//    }

    @When("I navigate to Orders page")
    public void navigate_to_orders_page() {
        ordersPageAA = new OrdersPage_AA(driver);
        ordersPageAA.navigateToOrdersPage();
    }

    @Then("I see all my orders")
    public void verify_orders_displayed() {

        if (ordersPageAA.isNoOrdersMessageDisplayed()) {
            System.out.println("VALID: User has no orders (expected state)");
            return;
        }

        int orderCount = ordersPageAA.getOrderCount();
        if (orderCount > 0) {
            System.out.println("VALID: User has " + orderCount + " orders");
            return;
        }

        throw new IllegalStateException(
                "UI is inconsistent: No orders message not shown AND order count is 0"
        );
    }
}