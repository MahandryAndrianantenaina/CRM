package itu.com.CRM.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import itu.com.CRM.config.ApiClient;
import itu.com.CRM.features.request.LoginRequest;
import itu.com.CRM.features.result.LoginResult;
import itu.com.CRM.response.ApiSuccessResult;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class SecurityService {

    private final ApiClient _apiClient;

    public SecurityService(ApiClient apiClient) {
        this._apiClient = apiClient;
    }

    public ApiSuccessResult<LoginResult> login(LoginRequest request) {
        String endpoint = "/Security/Login";
        ParameterizedTypeReference<ApiSuccessResult<LoginResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<LoginResult>>() {};
        ApiSuccessResult<LoginResult> result = _apiClient.callApi(endpoint, HttpMethod.POST, request, responseType);
        if (result.getContent() != null) {
            String token = result.getContent().getData().getAccessToken(); 
            _apiClient.setToken(token);
        }
        return result;
    }
}
