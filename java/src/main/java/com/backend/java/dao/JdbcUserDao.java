package com.backend.java.dao;

import com.backend.java.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDao implements UserDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "Select user_id, username, passwordHash, firstName, lastName, role, email, user_location, isAdvocate from users";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);

        while (rs.next()) {
            User user = mapRowToUser(rs);
            users.add(user);
        }
        return users;
    }


    @Override
    public void registerUser(User user) {
        String insertSql = "insert into users (username, passwordHash, firstName, lastName, role, email, user_location, isAdvocate) values (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(insertSql, user.getUsername(), user.getPasswordHash(), user.getFirstName(), user.getLastName(), user.getRole(), user.getEmail(), user.getUserLocation(), user.isAdvocate());
    }

    @Override
    public User findUserByUsernamePassword(String username, String password) {
        String sql = "Select user_id, username, passwordHash, firstName, lastName, role, email, user_location, isAdvocate from users where username = ? and passwordHash = ?";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, username, password);

        User user = new User();
        if (rs.next()) {
            user = mapRowToUser(rs);
        }

        return user;
    }

    @Override
    public List<User> getUsersByRole(String role) {
        List<User> users = new ArrayList<>();
        String sql = "Select user_id, username, passwordHash, firstName, lastName, role, email, user_location, isAdvocate from users where role = ?";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, role);

        while (rs.next()) {
            User user = mapRowToUser(rs);
            users.add(user);
        }
        return users;
    }

    @Override
    public User findUserByUsername(String username) {
        String sql = "Select user_id, username, passwordHash, firstName, lastName, role, email, user_location, isAdvocate from users where username = ?";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, username);
        User user = new User();

        if (rs.next()) {
            user = mapRowToUser(rs);
        }

        return user;
    }

    @Override
    public void updateProfile(User user) {
        String sql = "update user set username = ?, role = ?, email = ?, user_location = ?, isAdvocate = ? where user_id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getRole(), user.getEmail(), user.getUserLocation(), user.isAdvocate(), user.getUserId());
    }

    @Override
    public User getUserById(int id) {
        String sql = "Select user_id, username, passwordHash, firstName, lastName, role, email, user_location, isAdvocate from users where user_id = ?";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, id);

        User user = new User();

        if (rs.next()) {
            user = mapRowToUser(rs);
        }

        return user;

    }


    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPasswordHash(rs.getString("passwordHash"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setRole(rs.getString("role"));
        user.setEmail(rs.getString("email"));
        user.setUserLocation(rs.getString("user_location"));
        user.setAdvocate(rs.getBoolean("isAdvocate"));

        return user;

    }


}
