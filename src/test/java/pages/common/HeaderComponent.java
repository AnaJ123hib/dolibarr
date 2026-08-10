package pages.common;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends PageObject {
    @FindBy(css = "a[contains(@href, 'product/index.php?mainmenu=products')]")
    private WebElementFacade productButton;
    @FindBy (css = "#mainmenua_members") private WebElementFacade mememberButton;
    @FindBy (id = "mainmenutd_commercial") private WebElementFacade commercialButton;
    @FindBy (id = "mainmenutd_billing") private WebElementFacade billingButton;

    public void clickProduct(){
        productButton.click();
    }
    public void clickMember() {
        mememberButton.click();
    }
    public void clickCommercial() { commercialButton.click(); }
    public void clickBilling() { billingButton.click(); }

}
