package com.edutilos.dao;

import com.edutilos.security.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nijat Aghayev on 27.05.19.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
