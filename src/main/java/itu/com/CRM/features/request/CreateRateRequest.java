package itu.com.CRM.features.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRateRequest
{
    private double ratio;
    private String validateDate;
    private String expiringeDate;
}

