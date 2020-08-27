package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AccountQueryEntity;

public interface AccountQueryService {
    public List<Object> listEventsForAccount(String accountNumber);
    public AccountQueryEntity getAccount(String accountNumber);
    
}