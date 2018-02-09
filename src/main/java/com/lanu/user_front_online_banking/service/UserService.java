package com.lanu.user_front_online_banking.service;

import com.lanu.user_front_online_banking.domain.User;
import com.lanu.user_front_online_banking.domain.security.UserRole;

import java.util.Set;


public interface UserService {
    void save(User user);

    User createUser(User user, Set<UserRole> userRoles);

    User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);
}
