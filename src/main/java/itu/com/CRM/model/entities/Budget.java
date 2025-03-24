package itu.com.CRM.model.entities;

import java.time.LocalDateTime;

import itu.com.CRM.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Budget extends BaseEntity {

    private String id;
    private String number;
    private String title;
    private String description;
    private String budgetDate;
    private String status;
    private Double amount;
    private String campaignId;
    private Campaign campaign;
}

