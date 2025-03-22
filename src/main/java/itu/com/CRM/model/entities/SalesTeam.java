package itu.com.CRM.model.entities;

import java.util.ArrayList;
import java.util.List;

import itu.com.CRM.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesTeam extends BaseEntity {

    private String name;
    private String description;
    private List<SalesRepresentative> salesRepresentativeList;

    public SalesTeam() {
        this.salesRepresentativeList = new ArrayList<>();
    }

}
