package itu.com.CRM.model.entities;

import java.time.LocalDateTime;

import itu.com.CRM.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rate  extends BaseEntity {

    private double Ratio;
    private LocalDateTime ValidateDate;
    private LocalDateTime ExpiringeDate;
    
}
