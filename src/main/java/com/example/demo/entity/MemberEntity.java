package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {
    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String dateOfBirth;
    private String gender;
    private String occupation;
    private String maritalStatus;
    private String education;
}
