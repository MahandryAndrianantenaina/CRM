package itu.com.CRM.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import itu.com.CRM.config.ApiClient;
import itu.com.CRM.features.request.DeleteExpenseRequest;
import itu.com.CRM.features.request.UpdateExpenseRequest;
import itu.com.CRM.features.result.DeleteExpenseResult;
import itu.com.CRM.features.result.GetExpenseListResult;
import itu.com.CRM.features.result.GetExpenseSingleResult;
import itu.com.CRM.features.result.UpdateExpenseResult;
// import itu.com.CRM.features.request.DeleteExpenseRequest;
// import itu.com.CRM.features.request.UpdateExpenseRequest;
// import itu.com.CRM.features.result.DeleteExpenseResult;
// import itu.com.CRM.features.result.GetExpenseListResult;
// import itu.com.CRM.features.result.GetExpenseSingleResult;
// import itu.com.CRM.features.result.UpdateExpenseResult;
import itu.com.CRM.response.ApiSuccessResult;

@Service
public class ExpenseService {

    private final ApiClient _apiClient;

    public ExpenseService(ApiClient apiClient) {
        this._apiClient = apiClient;
    }

    public ApiSuccessResult<GetExpenseListResult> getListExpense() {
        String endpoint = "/Expense/GetExpenseList";
        ParameterizedTypeReference<ApiSuccessResult<GetExpenseListResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<GetExpenseListResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.GET, null, responseType);
    }

    public ApiSuccessResult<GetExpenseSingleResult> getUniqueExpense(String id) {
        String endpoint = "/Expense/GetExpenseSingle?id="+id;
        ParameterizedTypeReference<ApiSuccessResult<GetExpenseSingleResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<GetExpenseSingleResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.GET, null, responseType);
    }

    public ApiSuccessResult<UpdateExpenseResult> updateExpense(UpdateExpenseRequest request) {
        String endpoint = "/Expense/UpdateExpense";
        ParameterizedTypeReference<ApiSuccessResult<UpdateExpenseResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<UpdateExpenseResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.POST, request, responseType);
    }

    public ApiSuccessResult<DeleteExpenseResult> deleteExpense(DeleteExpenseRequest request) {
        String endpoint = "/Expense/DeleteExpense";
        ParameterizedTypeReference<ApiSuccessResult<DeleteExpenseResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<DeleteExpenseResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.POST, request, responseType);
    }
}
