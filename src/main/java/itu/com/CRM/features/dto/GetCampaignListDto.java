package itu.com.CRM.features.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCampaignListDto {
    private String id;
    private String number;
    private String title;
    private String description;
    private double targetRevenueAmount;
    private String campaignDateStart;
    private String campaignDateFinish;
    private int status;
    private String statusName;  
    private double amount;
    private String salesTeamId;
    private String salesTeamName;
    private String createdAtUtc;
}
