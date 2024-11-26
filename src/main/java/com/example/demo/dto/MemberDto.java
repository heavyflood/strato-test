package com.example.demo.dto;

import com.example.demo.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
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

    @Builder
    public MemberDto(int id, String name, String password, String email, String phone, String address, String city, String state, String zipcode, String dateOfBirth, String gender, String occupation, String maritalStatus, String education) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.occupation = occupation;
        this.maritalStatus = maritalStatus;
        this.education = education;
    }

    public static MemberDto of(MemberEntity memberEntity) {
        return MemberDto.builder()
               .id(memberEntity.getId())
               .name(memberEntity.getName())
               .password(memberEntity.getPassword())
               .email(memberEntity.getEmail())
               .phone(memberEntity.getPhone())
               .address(memberEntity.getAddress())
               .city(memberEntity.getCity())
               .state(memberEntity.getState())
               .zipcode(memberEntity.getZipcode())
               .dateOfBirth(memberEntity.getDateOfBirth())
               .gender(memberEntity.getGender())
               .occupation(memberEntity.getOccupation())
               .maritalStatus(memberEntity.getMaritalStatus())
               .education(memberEntity.getEducation())
               .build();
    }

    @Getter
    public static class MemberRequestDto {
        private int id;
        private String name;
        private String email;
        private String phone;
    }
}
