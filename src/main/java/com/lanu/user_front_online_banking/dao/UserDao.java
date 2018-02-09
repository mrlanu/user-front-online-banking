package com.lanu.user_front_online_banking.dao;

import com.lanu.user_front_online_banking.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
