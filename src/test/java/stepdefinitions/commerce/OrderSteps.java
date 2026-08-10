package stepdefinitions.commerce;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.OrderData;
import pages.commerce.CreateOrderPage;
import pages.commerce.OrderDetailsPage;
import pages.commerce.OrderListPage;
import utils.OrderFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderSteps {
    CreateOrderPage createOrderPage;
    OrderDetailsPage orderDetailsPage;
    OrderListPage orderListPage;
    OrderData order = OrderFactory.DEFAULT_ORDER;
    @And("the user is on new order page")
    public void theUserIsOnNewOrderPage() {
        createOrderPage.navigateToNewOrder();
    }

    @When("the user starts creating the order information")
    public void theUserStartsCreatingTheOrderInformation() {
        createOrderPage.fillOrderForm(order);
    }

    @And("the user saves the order information")
    public void theUserSavesTheOrderInformation() {
        createOrderPage.saveOrder();
        orderDetailsPage.setOrderId(order);
    }

    @Then("the order details page should be displayed")
    public void theOrderDetailsPageShouldBeDisplayed() {
        assertThat(orderDetailsPage.isOrderDetailDisplayed()).isTrue();
    }

    @And("the user cancel the order information")
    public void theUserCancelTheOrderInformation() {
        createOrderPage.cancelOrder();
    }

    @Then("the order should not be created")
    public void theOrderShouldNotBeCreated() {
        assertThat(orderListPage.isListDisplayed()).isTrue();
    }
}
