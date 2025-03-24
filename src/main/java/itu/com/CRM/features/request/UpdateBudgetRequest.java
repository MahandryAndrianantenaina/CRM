package itu.com.CRM.features.request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBudgetRequest {
    private String id;
    private String title;
    private String description;
    private String budgetDate;
    private String status;
    private double amount;
    private String campaignId;
    private String updatedById;
}
