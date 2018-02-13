package com.lanu.user_front_online_banking.service;

import com.lanu.user_front_online_banking.domain.Recipient;

import java.util.Optional;

public interface RecipientService {

    void saveRecipient(Recipient recipient);

    void deleteById(Long id);

    Optional<Recipient> findById(Long id);
}
