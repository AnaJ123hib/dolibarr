package utils;

import models.LineData;

public class LineFactory {
    public static LineData DEFAULT_LINE = LineData
            .builder()
            .type("Product")
            .description("test")
            .price(20)
            .percentage(10)
            .build();
}
