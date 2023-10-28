package com.example.story.payload.response;

import lombok.Data;

import java.util.List;
@Data

public class JwtResponse {
    private String accessToken;
    private String type ="Bearer ";
    private Long UserId;

    private String firstName;

    private String lastname;

    private String email;

    private Integer age;

    private String address;

    private  String userName;

    private String phoneNumber;

    private List<String> listRole;
    private String refreshToken;

    public JwtResponse(String accessToken, String firstName, String lastname, String email, Integer age, String userName, String phoneNumber, List<String> listRole,String refreshToken) {
        this.accessToken = accessToken;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.listRole = listRole;
        this.refreshToken=refreshToken;
    }
}