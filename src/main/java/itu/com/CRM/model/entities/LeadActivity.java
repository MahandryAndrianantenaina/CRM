package itu.com.CRM.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import itu.com.CRM.model.common.BaseEntity;
import itu.com.CRM.model.enums.LeadActivityType;

@Getter
@Setter
public class LeadActivity extends BaseEntity {

    private String leadId;
    private Lead lead;
    private String number;
    private String summary;
    private String description;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private LeadActivityType type;
    private String attachmentName;
}

