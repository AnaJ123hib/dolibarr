package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CustomerData {
    private String id;
    private int memberType;
    private String natureOfMember;
    private String company;
    private String title;
    private String lastName;
    private String firstName;
    private String gender;
    private String email;
    private String web;
    private String address;
    private String zipCode;
    private String city;
    private String country;
    private String state;
    private String businessPhone;
    private String personalPhone;
    private String mobile;
    private String dateOfBirth;
    private String publicMembership;
    private String tags;
    private String extraData;

    public String getUsername(){
        return company == null || company.isBlank()
                ? String.format("%s %s", firstName, lastName)
                : String.format("%s %s (%s)", firstName, lastName, company);
    }
}
