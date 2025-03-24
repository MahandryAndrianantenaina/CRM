package itu.com.CRM.features.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateExpenseRequest {
    private String id;
    private String title;
    private String description;
    private String expenseDate;
    private String status;
    private double amount;
    private String campaignId;
    private String updatedById;
}
