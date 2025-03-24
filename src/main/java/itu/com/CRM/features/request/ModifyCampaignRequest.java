package itu.com.CRM.features.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyCampaignRequest {
    private String id;
    private double targetRevenueAmount;
}
