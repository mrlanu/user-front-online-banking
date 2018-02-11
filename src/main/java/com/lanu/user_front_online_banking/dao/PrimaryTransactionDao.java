package com.lanu.user_front_online_banking.dao;

import com.lanu.user_front_online_banking.domain.PrimaryTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {
    List<PrimaryTransaction> findAll();
}
