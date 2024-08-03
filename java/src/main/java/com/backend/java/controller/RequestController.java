package com.backend.java.controller;

import com.backend.java.dao.RequestDao;
import com.backend.java.model.Request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin

public class RequestController {

    private RequestDao requestdao;

    @GetMapping("/request")
    public List<Request> getAllRequest(){
        return requestdao.getAllRequest();
    }
    @GetMapping("/request/{id}")
    public Request getRequestById(@PathVariable int id){
        return requestdao.getRequestById(id);
    }
    @PostMapping("/request/new-request")
    public void addRequest(@RequestBody Request request){
         requestdao.addRequest(request);
    }



}
