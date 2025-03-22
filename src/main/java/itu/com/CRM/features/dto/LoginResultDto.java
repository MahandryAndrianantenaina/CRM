package itu.com.CRM.features.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResultDto {
    private String accessToken;
    private String refreshToken;
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String companyName;
    private String avatar;
    private List<MenuNavigationTreeNodeDto> menuNavigation;
    private List<String> roles;
}
