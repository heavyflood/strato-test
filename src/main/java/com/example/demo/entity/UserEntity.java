package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
}
