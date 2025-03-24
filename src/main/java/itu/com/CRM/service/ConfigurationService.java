package itu.com.CRM.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import itu.com.CRM.config.ApiClient;
import itu.com.CRM.features.request.CreateRateRequest;
import itu.com.CRM.features.result.CreateRateResult;
import itu.com.CRM.response.ApiSuccessResult;

@Service
public class ConfigurationService {

    private final ApiClient _apiClient;

    public ConfigurationService(ApiClient apiClient) {
        this._apiClient = apiClient;
    }

    public ApiSuccessResult<CreateRateResult> createRate(CreateRateRequest request) {
        String endpoint = "/Rate/CreateRate";
        ParameterizedTypeReference<ApiSuccessResult<CreateRateResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<CreateRateResult>>() {};
        ApiSuccessResult<CreateRateResult> result = _apiClient.callApi(endpoint, HttpMethod.POST, request, responseType);
        return result;
    }
}
