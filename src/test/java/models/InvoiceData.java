package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
@Setter
public class InvoiceData {
    private int customerIndex;
    private String date;
    private String paymentTerms;
    private String paymentMethod;
    private String bankAccount;
    private String source;
    private String id;

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String getCurrentDate() {
        return LocalDate.now()
                .minusDays(5)
                .format(DATE_FORMAT);
    }
}
