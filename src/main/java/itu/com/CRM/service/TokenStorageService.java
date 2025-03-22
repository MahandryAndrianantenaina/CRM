package itu.com.CRM.service;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class TokenStorageService {
    private String token;
}
