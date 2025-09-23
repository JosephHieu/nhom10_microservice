package com.josephhieu.userservice.service;

import com.josephhieu.userservice.model.User;
import com.josephhieu.userservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Cacheable(value = "allUsers", key = "'all'")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
