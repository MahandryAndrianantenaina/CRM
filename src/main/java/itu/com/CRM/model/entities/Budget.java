package itu.com.CRM.model.entities;

import java.time.LocalDateTime;

import itu.com.CRM.model.common.BaseEntity;
import itu.com.CRM.model.enums.BudgetStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Budget extends BaseEntity {

    private String number;
    private String title;
    private String description;
    private LocalDateTime budgetDate;
    private BudgetStatus status;
    private Double amount;
    private String campaignId;
    private Campaign campaign;
}

