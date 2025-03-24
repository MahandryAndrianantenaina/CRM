package itu.com.CRM.features.request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCampaignRequest {
    private String id;
    private String title;
    private String description;
    private String campaignDateStart;
    private String campaignDateFinish;
    private String status;
    private double targetRevenueAmount;
    private String SalesTeamId;
    private String updatedById;
}
