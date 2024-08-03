package com.backend.java.controller;

import com.backend.java.dao.UserDao;
import com.backend.java.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private UserDao userDao;

    public  UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateProfile(@Validated @RequestBody User user) {
        userDao.updateProfile(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public void getUserById(@PathVariable int id) {
        userDao.getUserById(id);
    }

    @RequestMapping(value = "/users/{role}", method = RequestMethod.GET)
    public List<User> getUsers(@PathVariable String role) {
        return userDao.getUsersByRole(role);
    }

    @RequestMapping(value = "/usernames/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable String username) {
        return userDao.findUserByUsername(username);
    }

}
