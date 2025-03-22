package itu.com.CRM.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import itu.com.CRM.config.ApiClient;
import itu.com.CRM.features.result.GetCRMDashboardResult;
import itu.com.CRM.response.ApiSuccessResult;

@Service
public class DashboardService {

    private final ApiClient _apiClient;

    public DashboardService(ApiClient apiClient) {
        this._apiClient = apiClient;
    }

    public ApiSuccessResult<GetCRMDashboardResult> getCRMDashboard() {
        String endpoint = "/Dashboard/GetCRMDashboard";
        ParameterizedTypeReference<ApiSuccessResult<GetCRMDashboardResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<GetCRMDashboardResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.GET, null, responseType);
    }
}
