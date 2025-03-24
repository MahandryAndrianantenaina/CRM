package itu.com.CRM.features.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutResultDto {
    public String accessToken;
    public String refreshToken;
    public String userId;
    public String email;
    public String firstName;
    public String lastName;
    public String companyName;
    public List<String> userClaims;
}
