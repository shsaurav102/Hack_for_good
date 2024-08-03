package com.backend.java.dao;

import com.backend.java.model.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcRequest implements RequestDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcRequest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Request> getAllRequest() {
        String sql = "SELECT * FROM requests";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Request> requestList = new ArrayList<>();
        while(results.next()){
            Request request = mapRowRequest(results);
            requestList.add(request);

        }
    return requestList;
    }

    @Override
    public Request getRequestById(int id) {
        String sql = "SELECT * FROM requests WHERE request_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            return mapRowRequest(result);
        }
        return null;
    }

    @Override
    public void addRequest(Request request) {
        String sql = "INSERT INTO requests (request_service, details,isCompleted,completedBy,request_location) "+
                "VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,request.getRequestService(), request.getDetails(), request.isCompleted(),
                request.getCompletedBy(), request.getRequestLocation() );
    }


    private Request mapRowRequest(SqlRowSet rs){
        Request request = new Request();
        request.setRequestId(rs.getInt("request_id"));
        request.setRequestService(rs.getInt("request_service"));
        request.setDetails(rs.getString("details"));
        request.setCompleted(rs.getBoolean("isCompleted"));
        request.setCompletedBy(rs.getInt("completedBy"));
        request.setRequestLocation(rs.getString("request_location"));
        return request;

    }
}
