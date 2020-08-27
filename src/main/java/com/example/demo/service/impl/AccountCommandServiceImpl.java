package com.example.demo.service.impl;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountCreateDTO;
import com.example.demo.dto.MoneyCreditDTO;
import com.example.demo.dto.MoneyDebitDTO;
import com.example.demo.model.eventsource.CreateAccountCommand;
import com.example.demo.model.eventsource.CreditMoneyCommand;
import com.example.demo.model.eventsource.DebitMoneyCommand;
import com.example.demo.service.AccountCommandService;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

	@Autowired
    private CommandGateway commandGateway;


    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(), accountCreateDTO.getStartingBalance(), accountCreateDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoneyCommand(accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoneyCommand(accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()));
    }
}