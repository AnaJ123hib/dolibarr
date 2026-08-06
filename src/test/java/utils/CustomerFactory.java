package utils;

import models.CustomerData;

public class CustomerFactory {
    public static CustomerData DEFAULT_CUSTOMER = CustomerData.builder()
            .memberType("Production")
            .natureOfMember("Individual")
            .company("Company XYZ")
            .lastName("Jimenes")
            .firstName("Valentina")
            .email("email@test.com")
            .web("testWeb.com")
            .address("Ca. 3423")
            .personalPhone("987654321")
            .mobile("987654321")
            .dateOfBirth("10/10/2000")
            .build();

    public static CustomerData EDITED_CUSTOMER = CustomerData.builder()
            .company("Company XYZ edited")
            .lastName("Jimenes edited")
            .firstName("Valentina edited")
            .build();
    public static CustomerData RANDOM_CUSTOMER = CustomerData.builder()
            .memberType("Production")
            .natureOfMember("Individual")
            .company("Company XYZ")
            .lastName("Jimenes" + System.currentTimeMillis())
            .firstName("Valentina" + System.currentTimeMillis())
            .email("email@test.com")
            .web("testWeb.com")
            .address("Ca. 3423")
            .personalPhone("987654321")
            .mobile("987654321")
            .dateOfBirth("10/10/2000")
            .id(String.valueOf(System.currentTimeMillis()))
            .build();

    public static CustomerData CUSTOMER_WITHOUT_NAME = CustomerData.builder()
            .memberType("Production")
            .natureOfMember("Individual")
            .company("Company XYZ")
            .lastName("Jimenes")
            .email("email@test.com")
            .web("testWeb.com")
            .address("Ca. 3423")
            .personalPhone("987654321")
            .mobile("987654321")
            .dateOfBirth("10/10/2000")
            .build();

    public static CustomerData CUSTOMER_WITHOUT_TYPE = CustomerData.builder()
            .natureOfMember("Individual")
            .company("Company XYZ")
            .lastName("Jimenes")
            .firstName("Valentina")
            .email("email@test.com")
            .web("testWeb.com")
            .address("Ca. 3423")
            .personalPhone("987654321")
            .mobile("987654321")
            .dateOfBirth("10/10/2000")
            .build();

    public static CustomerData getCustomerWithoutField(String field) {
        CustomerData.CustomerDataBuilder builder = CustomerData.builder()
                .memberType("Production")
                .natureOfMember("Individual")
                .company("Company XYZ")
                .lastName("Jimenes")
                .firstName("Valentina")
                .email("email@test.com")
                .web("testWeb.com")
                .address("Ca. 3423")
                .personalPhone("987654321")
                .mobile("987654321")
                .dateOfBirth("10/10/2000");

        switch (field) {
            case "Name":
                builder.firstName(null);
                break;

            case "Last name":
                builder.lastName(null);
                break;

            case "Member Type":
                builder.memberType(null);
                break;

            case "Nature of member":
                builder.natureOfMember(null);
                break;


        }

        return builder.build();
    }
}
