package itu.com.CRM.features.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteExpenseRequest {
    public String id;
    public String deletedById;
}
