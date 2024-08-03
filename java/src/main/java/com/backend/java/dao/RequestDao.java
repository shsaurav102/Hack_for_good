package com.backend.java.dao;

import com.backend.java.model.Request;

import java.util.List;

public interface RequestDao {

    List<Request> getAllRequest();

    Request getRequestById(int id);

    void addRequest(Request request);
}
