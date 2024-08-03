package com.backend.java.model;

public class User {

    private int userId;
    private String username;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private String role;
    private String email;
    private String userLocation;
    private boolean isAdvocate;

    public User() {};

    public User(int userId, String username, String passwordHash, String firstName, String lastName, String role, String email, String userLocation, boolean isAdvocate) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
        this.userLocation = userLocation;
        this.isAdvocate = isAdvocate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public boolean isAdvocate() {
        return isAdvocate;
    }

    public void setAdvocate(boolean advocate) {
        isAdvocate = advocate;
    }
}
