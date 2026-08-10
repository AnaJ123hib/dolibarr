package pages.commerce;

import models.OrderData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageObject {
    @FindBy(css = ".refid span.valignmiddle") private WebElementFacade orderID;
    public boolean isOrderDetailDisplayed() {
        return orderID.isVisible();
    }

    public void setOrderId(OrderData order){
        order.setId(orderID.getText()
                .replace("(", "")
                .replace(")", ""));
    }
}
