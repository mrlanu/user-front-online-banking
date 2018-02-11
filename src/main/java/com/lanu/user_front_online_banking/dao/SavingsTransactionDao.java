package com.lanu.user_front_online_banking.dao;

import com.lanu.user_front_online_banking.domain.SavingsTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {
    List<SavingsTransaction> findAll();
}
