package itu.com.CRM.features.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyBudgetRequest {
    private String id;
    private double amount;
}
