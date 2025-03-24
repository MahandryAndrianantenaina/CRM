package itu.com.CRM.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import itu.com.CRM.config.ApiClient;
import itu.com.CRM.features.request.DeleteBudgetRequest;
import itu.com.CRM.features.request.UpdateBudgetRequest;
import itu.com.CRM.features.result.DeleteBudgetResult;
import itu.com.CRM.features.result.GetBudgetListResult;
import itu.com.CRM.features.result.GetBudgetSingleResult;
import itu.com.CRM.features.result.UpdateBudgetResult;
import itu.com.CRM.response.ApiSuccessResult;

@Service
public class BudgetService {

    private final ApiClient _apiClient;

    public BudgetService(ApiClient apiClient) {
        this._apiClient = apiClient;
    }

    public ApiSuccessResult<GetBudgetListResult> getListBuget() {
        String endpoint = "/Budget/GetBudgetList";
        ParameterizedTypeReference<ApiSuccessResult<GetBudgetListResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<GetBudgetListResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.GET, null, responseType);
    }

    public ApiSuccessResult<GetBudgetSingleResult> getUniqueBudget(String id) {
        String endpoint = "/Budget/GetBudgetSingle?id="+id;
        ParameterizedTypeReference<ApiSuccessResult<GetBudgetSingleResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<GetBudgetSingleResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.GET, null, responseType);
    }

    public ApiSuccessResult<UpdateBudgetResult> updateBudget(UpdateBudgetRequest request) {
        String endpoint = "/Budget/UpdateBudget";
        ParameterizedTypeReference<ApiSuccessResult<UpdateBudgetResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<UpdateBudgetResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.POST, request, responseType);
    }

    public ApiSuccessResult<DeleteBudgetResult> deleteBudget(DeleteBudgetRequest request) {
        String endpoint = "/Budget/DeleteBudget";
        ParameterizedTypeReference<ApiSuccessResult<DeleteBudgetResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<DeleteBudgetResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.POST, request, responseType);
    }
}
