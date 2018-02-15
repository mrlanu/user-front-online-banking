package com.lanu.user_front_online_banking.dao;

import com.lanu.user_front_online_banking.domain.Recipient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipientDao extends CrudRepository<Recipient, Long> {
    List<Recipient> findAll();
    Recipient findByName(String recipientName);
}
