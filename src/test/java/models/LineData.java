package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LineData {
    private String type;
    private String description;
    private int price;
    private double percentage;
}
