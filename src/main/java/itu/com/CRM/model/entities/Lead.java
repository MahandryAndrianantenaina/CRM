package itu.com.CRM.model.entities;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import itu.com.CRM.model.common.BaseEntity;
import itu.com.CRM.model.enums.ClosingStatus;
import itu.com.CRM.model.enums.PipelineStage;

import java.time.LocalDateTime;

@Getter
@Setter
public class Lead extends BaseEntity {

    private String number;
    private String title;
    private String description;
    private String companyName;
    private String companyDescription;
    private String companyAddressStreet;
    private String companyAddressCity;
    private String companyAddressState;
    private String companyAddressZipCode;
    private String companyAddressCountry;
    private String companyPhoneNumber;
    private String companyFaxNumber;
    private String companyEmail;
    private String companyWebsite;
    private String companyWhatsApp;
    private String companyLinkedIn;
    private String companyFacebook;
    private String companyInstagram;
    private String companyTwitter;
    private LocalDateTime dateProspecting;
    private LocalDateTime dateClosingEstimation;
    private LocalDateTime dateClosingActual;
    private Double amountTargeted;
    private Double amountClosed;
    private Double budgetScore;
    private Double authorityScore;
    private Double needScore;
    private Double timelineScore;
    private PipelineStage pipelineStage;
    private ClosingStatus closingStatus;
    private String closingNote;
    private String campaignId;
    private Campaign campaign;
    private String salesTeamId;
    private SalesTeam salesTeam;
    private List<LeadContact> leadContacts;
    private List<LeadActivity> leadActivities;
}

