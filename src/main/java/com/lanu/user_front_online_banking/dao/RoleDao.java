package com.lanu.user_front_online_banking.dao;

import com.lanu.user_front_online_banking.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
