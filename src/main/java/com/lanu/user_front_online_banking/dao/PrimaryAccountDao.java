package com.lanu.user_front_online_banking.dao;

import com.lanu.user_front_online_banking.domain.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {
    PrimaryAccount findByAccountNumber(int accountNumber);
}
