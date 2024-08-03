package com.backend.java.dao;

import com.backend.java.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void registerUser(User user);

    User findUserByUsernamePassword(String username, String password);

    List<User> getUsersByRole(String role);

    User findUserByUsername(String username);

    void updateProfile(User user);

    User getUserById(int id);
}
