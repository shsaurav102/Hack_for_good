package com.backend.java.controller;


import com.backend.java.dao.UserDao;
import com.backend.java.model.LoginDto;
import com.backend.java.model.LoginResponseDto;
import com.backend.java.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    private UserDao userDao;

    public AuthController(UserDao userDao) {
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@Validated @RequestBody User newUser) {

        userDao.registerUser(newUser);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDto> login(@Validated @RequestBody LoginDto loginDto) {

        String jwt = "ksadjflk;sajdf@$sfasfs;as";

        User user = userDao.findUserByUsernamePassword(loginDto.getUsername(), loginDto.getPasswordHash());

        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(new LoginResponseDto(jwt, user), HttpStatus.OK);
    }





}
