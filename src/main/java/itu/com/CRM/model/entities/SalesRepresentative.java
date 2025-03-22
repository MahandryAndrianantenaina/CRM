package itu.com.CRM.model.entities;

import itu.com.CRM.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesRepresentative extends BaseEntity {

    private String name;
    private String number;
    private String jobTitle;
    private String employeeNumber;
    private String phoneNumber;
    private String emailAddress;
    private String description;
    private String salesTeamId;
    private SalesTeam salesTeam;
}
