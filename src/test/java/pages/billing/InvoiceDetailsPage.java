package pages.billing;

import static components.FormUtils.*;
import models.InvoiceData;
import models.LineData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import org.openqa.selenium.By;
public class InvoiceDetailsPage extends PageObject {
    @FindBy(css = ".refid span.valignmiddle") private WebElementFacade billingID;
    @FindBy (id = "select_type") private WebElementFacade typeLineDropdown;
    @FindBy (id = "price_ht") private WebElementFacade priceInput;
    @FindBy (id = "remise_percent") private WebElementFacade percentageInput;
    @FindBy (id = "addline") private WebElementFacade addLineButton;
    @FindBy(css = "iframe.cke_wysiwyg_frame")
    private WebElementFacade descriptionFrame;
    @FindBy (css = "#tablelines tbody tr") private List<WebElementFacade> tableLine;
    @FindBy (css = ".ui-dialog-buttonset button:first-child") private WebElementFacade confirmButton;
    @FindBy (css = ".badge-status") private WebElementFacade invoiceStatus;
    @FindBy(css = "a[href*='/compta/facture/card.php'][href*='action=valid']")
    private WebElementFacade validateButton;

    public void fillDescription(String description) {
        descriptionFrame.waitUntilVisible();

        getDriver().switchTo().frame(descriptionFrame);

        WebElementFacade editor = find(By.cssSelector("body"));
        editor.waitUntilVisible();
        editor.click();
        editor.sendKeys(description);

        getDriver().switchTo().defaultContent();
    }

    public boolean isBillingDetailDisplayed() {
        return billingID.isVisible();
    }

    public void setOrderId(InvoiceData invoice){
        invoice.setId(billingID.getText()
                .replace("(", "")
                .replace(")", ""));
    }

    public void addLine(LineData line) {
        typeLineDropdown.selectByVisibleText(line.getType());
        typeIfNotNull(priceInput, String.valueOf(line.getPrice()));
        typeIfNotNull(percentageInput, String.valueOf(line.getPercentage()));
        fillDescription(line.getDescription());
        addLineButton.click();
    }

    public boolean isLineRecords() {
        return !tableLine.isEmpty();
    }

    public void validateLine() {
        validateButton.click();
        confirmButton.click();
    }

    public boolean isInvoiceNotPaid() {
        return "1".equals(invoiceStatus.getAttribute("data-status"));
    }
}
