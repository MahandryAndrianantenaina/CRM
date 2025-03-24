package itu.com.CRM.model.entities;


import itu.com.CRM.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expense extends BaseEntity {
    private String number;
    private String title;
    private String description;
    private String expenseDate;
    private String status;
    private Double amount;
    private String campaignId;
}

