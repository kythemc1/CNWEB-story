package com.example.story.payload.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}