package utils;

import models.InvoiceData;

import static models.InvoiceData.getCurrentDate;

public class InvoiceFactory {
    public static InvoiceData DEFAULT_INVOICE = InvoiceData
            .builder()
            .customerIndex(1)
            .date(getCurrentDate())
            .paymentTerms("30 days")
            .paymentMethod("Cash")
            .bankAccount("Account")
            .source("Internet")
            .build();
}
