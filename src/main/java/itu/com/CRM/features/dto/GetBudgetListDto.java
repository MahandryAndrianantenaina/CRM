package itu.com.CRM.features.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBudgetListDto {
    private String id;
    private String number;
    private String title;
    private String description;
    private String budgetDate;
    private int status;
    private String statusName;
    private double amount;
    private String campaignId;
    private String campaignName;
    private LocalDateTime createdAtUtc;
}
