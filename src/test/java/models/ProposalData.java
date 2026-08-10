package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProposalData {
    private int vendedorIndex;
    private String paymentTerms;
    private String paymentMethod;
    private String deliveryDate;
    private String id;
}
