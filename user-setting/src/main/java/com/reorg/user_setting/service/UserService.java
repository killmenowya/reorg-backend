package com.reorg.user_setting.service;

import java.util.ArrayList;
import java.util.List;


import com.reorg.user_setting.models.User;
import com.reorg.user_setting.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<User>();
        for (User user : users) {
            userList.add(user);
        }
        return userList;
    }

    public User getUserByEmail(String email) {
        return userRepository.findById(email).orElse(null);
    }

    public User updateUser(String email, User user) {
        user.setEmail(email);
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
