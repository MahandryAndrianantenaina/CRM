package itu.com.CRM.model.entities;

import itu.com.CRM.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Campaign extends BaseEntity {

    private String number;
    private String title;
    private String description;
    private Double targetRevenueAmount;
    private String campaignDateStart;
    private String campaignDateFinish;
    private String status;
    private String salesTeamId;
    private String salesTeam;

}

