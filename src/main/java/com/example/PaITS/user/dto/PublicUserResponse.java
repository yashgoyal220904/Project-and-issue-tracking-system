package com.example.PaITS.user.dto;


public class PublicUserResponse {

    private java.util.UUID id;
    private String username;
    private String email;
    private String fullName;
    private boolean isActive;

    public PublicUserResponse(java.util.UUID id, String username, String email, String fullName, boolean isActive) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.isActive = isActive;
    }

    public java.util.UUID getId() { return id; }
    
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    @com.fasterxml.jackson.annotation.JsonProperty("isActive")
    public boolean isActive() {
        return isActive;
    }
}