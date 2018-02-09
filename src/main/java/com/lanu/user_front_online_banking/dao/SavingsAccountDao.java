package com.lanu.user_front_online_banking.dao;

import com.lanu.user_front_online_banking.domain.SavingsAccount;
import org.springframework.data.repository.CrudRepository;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {
    SavingsAccount findByAccountNumber(int accountNumber);
}
