package itu.com.CRM.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import itu.com.CRM.config.ApiClient;
import itu.com.CRM.features.request.DeleteCampaignRequest;
import itu.com.CRM.features.request.UpdateCampaignRequest;
import itu.com.CRM.features.result.DeleteCampaignResult;
import itu.com.CRM.features.result.GetCampaignListResult;
import itu.com.CRM.features.result.GetCampaignSingleResult;
import itu.com.CRM.features.result.UpdateCampaignResult;
import itu.com.CRM.response.ApiSuccessResult;

@Service
public class CampaignService {

    private final ApiClient _apiClient;

    public CampaignService(ApiClient apiClient) {
        this._apiClient = apiClient;
    }

    public ApiSuccessResult<GetCampaignListResult> getListCampaign() {
        String endpoint = "/Campaign/GetCampaignList";
        ParameterizedTypeReference<ApiSuccessResult<GetCampaignListResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<GetCampaignListResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.GET, null, responseType);
    }

    public ApiSuccessResult<GetCampaignSingleResult> getUniqueCampaign(String id) {
        String endpoint = "/Campaign/GetCampaignSingle?id="+id;
        ParameterizedTypeReference<ApiSuccessResult<GetCampaignSingleResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<GetCampaignSingleResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.GET, null, responseType);
    }

    public ApiSuccessResult<UpdateCampaignResult> updateCampaign(UpdateCampaignRequest request) {
        String endpoint = "/Campaign/UpdateCampaign";
        ParameterizedTypeReference<ApiSuccessResult<UpdateCampaignResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<UpdateCampaignResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.POST, request, responseType);
    }

    public ApiSuccessResult<DeleteCampaignResult> deleteCampaign(DeleteCampaignRequest request) {
        String endpoint = "/Campaign/DeleteCampaign";
        ParameterizedTypeReference<ApiSuccessResult<DeleteCampaignResult>> responseType = 
            new ParameterizedTypeReference<ApiSuccessResult<DeleteCampaignResult>>() {};
        return _apiClient.callApi(endpoint, HttpMethod.POST, request, responseType);
    }
}
