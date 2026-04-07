package com.example.PaITS.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class AdminUserResponse {
    private UUID id;
    private String username;
    private String email;
    private String fullName;
    private String role;
    
    @com.fasterxml.jackson.annotation.JsonProperty("isActive")
    private boolean isActive;
}
