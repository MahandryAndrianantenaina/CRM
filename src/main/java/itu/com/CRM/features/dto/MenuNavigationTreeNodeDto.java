package itu.com.CRM.features.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuNavigationTreeNodeDto {
    
    private String id;
    private String name;
    private String pid;
    private String navURL;
    private boolean hasChild;
    private boolean expanded;
    private boolean isSelected;

}
