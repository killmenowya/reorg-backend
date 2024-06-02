package com.reorg.user_setting.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.reorg.user_setting.models.User;
import com.reorg.user_setting.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/email/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User user) {
        return userService.updateUser(email, user);
    }

    @DeleteMapping("/email/{email}")
    public void deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
    }
}
