package itu.com.CRM.features.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBudgetRequest {
    public String id;
    public String deletedById;
}
