package com.dhana.app.repository;
import com.dhana.app.service.UserService;
import com.dhana.app.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Optional;

public class UserRepository {
    public Optional<User> findById(int id) {
        return null;
    }
}
