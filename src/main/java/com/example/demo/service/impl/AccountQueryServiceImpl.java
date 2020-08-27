package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountQueryRepository;
import com.example.demo.model.AccountQueryEntity;
import com.example.demo.service.AccountQueryService;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {

    private final EventStore eventStore;
    private final AccountQueryRepository accountRepository;
    
    public AccountQueryServiceImpl(EventStore eventStore, AccountQueryRepository accountRepository) {
        this.eventStore = eventStore;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Object> listEventsForAccount(String accountNumber) {
        return eventStore.readEvents(accountNumber).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }

	@Override
	public AccountQueryEntity getAccount(String accountNumber) {
		 return accountRepository.findById(accountNumber).get();
	}
    
   
}
