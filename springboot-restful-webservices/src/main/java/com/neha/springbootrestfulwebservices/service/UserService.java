package com.neha.springbootrestfulwebservices.service;

import com.neha.springbootrestfulwebservices.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User updateUser(User user,long id);
    void deleteUserById(long id);

    void deleteAllUsers();
}
