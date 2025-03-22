package itu.com.CRM.model.entities;

import itu.com.CRM.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeadContact extends BaseEntity {

    private String leadId;
    private Lead lead;
    private String number;
    private String fullName;
    private String description;
    private String addressStreet;
    private String addressCity;
    private String addressState;
    private String addressZipCode;
    private String addressCountry;
    private String phoneNumber;
    private String faxNumber;
    private String mobileNumber;
    private String email;
    private String website;
    private String whatsApp;
    private String linkedIn;
    private String facebook;
    private String twitter;
    private String instagram;
    private String avatarName;
}

