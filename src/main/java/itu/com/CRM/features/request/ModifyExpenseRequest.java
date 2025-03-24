package itu.com.CRM.features.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyExpenseRequest {
    private String id;
    private double amount;
}
