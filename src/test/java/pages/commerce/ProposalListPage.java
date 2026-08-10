package pages.commerce;

import components.Table;
import models.ProposalData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProposalListPage extends PageObject {
    @FindBy (name = "search_ref") public WebElementFacade refFilter;
    @FindBy (className = "listwithfilterbefore") public WebElementFacade listTable;
    @FindBy(css = "a[href='/supplier_proposal/list.php?leftmenu=supplier_proposals']")
    public WebElementFacade listButton;
    Table table;

    public void selectProposal(ProposalData proposal) {
        table.findByFilter(refFilter, proposal.getId());
    }

    public boolean isThereResultProposal() {
        return table.isThereResults();
    }

    public boolean isListTableDisplayed() {
        return listTable.isVisible();
    }

    public void navigateToList(){listButton.click();}
}
