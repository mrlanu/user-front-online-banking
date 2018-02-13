package com.lanu.user_front_online_banking.service.user_service_impl;

import com.lanu.user_front_online_banking.dao.RecipientDao;
import com.lanu.user_front_online_banking.domain.Recipient;
import com.lanu.user_front_online_banking.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipientServiceImpl implements RecipientService {

    @Autowired
    private RecipientDao recipientDao;

    @Override
    public void saveRecipient(Recipient recipient) {
        recipientDao.save(recipient);
    }

    @Override
    public void deleteById(Long id) {
        recipientDao.deleteById(id);
    }

    @Override
    public Optional<Recipient> findById(Long id) {
        return recipientDao.findById(id);
    }
}
