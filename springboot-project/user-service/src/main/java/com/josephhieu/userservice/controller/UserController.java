package com.josephhieu.userservice.controller;

import com.josephhieu.userservice.dto.UserDto;
import com.josephhieu.userservice.model.User;
import com.josephhieu.userservice.repository.UserRepository;
import com.josephhieu.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return user;
    }

//    @GetMapping("/{id}")
//    public UserDto getUserById(@PathVariable Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        return new UserDto(user.getId(), user.getName(), user.getEmail());
//    }

    @PostMapping
//    @CacheEvict(value = "allUsers", allEntries = true)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
//    @CacheEvict(value = "allUsers", allEntries = true)
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
//    @CacheEvict(value = "allUsers", allEntries = true)
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
