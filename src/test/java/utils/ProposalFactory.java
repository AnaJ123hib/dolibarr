package utils;

import models.ProposalData;

public class ProposalFactory {
    public static ProposalData DEFAULT_PROPOSAL = ProposalData
            .builder()
            .vendedorIndex(1)
            .paymentTerms("30 días")
            .paymentMethod("Efectivo")
            .deliveryDate("10/10/2026")
            .build();
}
