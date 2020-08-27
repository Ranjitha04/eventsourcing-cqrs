package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.AccountQueryEntity;

public interface AccountQueryRepository extends CrudRepository<AccountQueryEntity, String> {
}