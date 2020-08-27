package com.example.demo;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Account;

@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<Account> accountAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<Account> repository = EventSourcingRepository.builder(Account.class).eventStore(eventStore).build();
        return repository;
    }
}