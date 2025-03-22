package itu.com.CRM.model.entities;

import java.time.LocalDateTime;
import java.util.List;

import itu.com.CRM.model.common.BaseEntity;
import itu.com.CRM.model.enums.CampaignStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Campaign extends BaseEntity {

    private String number;
    private String title;
    private String description;
    private Double targetRevenueAmount;
    private LocalDateTime campaignDateStart;
    private LocalDateTime campaignDateFinish;
    private CampaignStatus status;
    private String salesTeamId;
    private SalesTeam salesTeam;
    private List<Budget> campaignBudgetList = new java.util.ArrayList<>();
    private List<Expense> campaignExpenseList = new java.util.ArrayList<>();
    private List<Lead> campaignLeadList = new java.util.ArrayList<>();

}

