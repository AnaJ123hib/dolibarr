package utils;

import models.OrderData;

public class OrderFactory {
    public static OrderData DEFAULT_ORDER = OrderData
            .builder()
            .vendorIndex(1)
            .refVendor("test")
            .paymentTerms("30 days")
            .paymentMethod("Cash")
            .deliveryDate("10/10/2026")
            .build();
}
