package pages.commerce;

import models.ProposalData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProposalDetailsPage extends PageObject {
    @FindBy (css = ".refid span.valignmiddle") private WebElementFacade proposalId;

    public boolean isProposalDetailDisplayed() {
        return proposalId.isVisible();
    }

    public void setProposalId(ProposalData proposal){
        proposal.setId(proposalId.getText()
                .replace("(", "")
                .replace(")", ""));
    }
}
