package itu.com.CRM.config;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import itu.com.CRM.response.ApiErrorResult;
import itu.com.CRM.service.TokenStorageService;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@Component
public class ApiClient {

    private final RestTemplate _restTemplate;
    private final TokenStorageService _tokenStorageService;

    @Value("${csharp.api.base-url}") 
    private String _apiBaseUrl;

    public ApiClient(RestTemplate restTemplate, TokenStorageService tokenStorageService) {
        this._restTemplate = restTemplate;
        this._tokenStorageService = tokenStorageService;
    }

    @SuppressWarnings("null")
    public <T, R> T callApi(String endpoint, HttpMethod method, R request, ParameterizedTypeReference<T> responseType) {
        String token = _tokenStorageService.getToken(); 
        if (token == null && !endpoint.equals("/Security/Login")) {
            throw new RuntimeException("No authentication token found. Please log in first.");
        }

        String url = _apiBaseUrl + endpoint;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (token != null) {
            headers.setBearerAuth(token);
        }

        HttpEntity<R> entity = new HttpEntity<>(request, headers);

        ResponseEntity<T> response = _restTemplate.exchange(
            url,
            method,
            entity,
            responseType
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            ApiErrorResult errorResult = parseResponse(response.getBody().toString(), ApiErrorResult.class);
            handleError(errorResult);
            return null; 
        }
    }

    public void setToken(String token) {
        _tokenStorageService.setToken(token);
    }

    private <T> T parseResponse(String responseBody, Class<T> responseType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(responseBody, responseType);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse API response", e);
        }
    }

    private ModelAndView handleError(ApiErrorResult errorResult) {
        ModelAndView modelAndView = new ModelAndView("erreur"); 
        modelAndView.addObject("errorCode", errorResult.getCode());
        modelAndView.addObject("errorMessage", errorResult.getMessage());
        if (errorResult.getError() != null) {
            modelAndView.addObject("errorType", errorResult.getError().getExceptionType());
            modelAndView.addObject("stackTrace", errorResult.getError().getStackTrace());
        }

        return modelAndView;
    }
}