package com.lepton.surveyauth.entity.dto;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zip;
}
