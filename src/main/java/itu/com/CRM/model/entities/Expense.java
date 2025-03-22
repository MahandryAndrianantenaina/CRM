package itu.com.CRM.model.entities;

import java.time.LocalDateTime;

import itu.com.CRM.model.common.BaseEntity;
import itu.com.CRM.model.enums.ExpenseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expense extends BaseEntity {
    private String number;
    private String title;
    private String description;
    private LocalDateTime expenseDate;
    private ExpenseStatus status;
    private Double amount;
    private String campaignId;
    private Campaign campaign;
}

