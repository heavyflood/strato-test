package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginResultDto {
    private MemberDto member;
    private String token;
    private String expiration;

    @Builder
    public LoginResultDto(MemberDto member, String token, String expiration) {
        this.member = member;
        this.token = token;
        this.expiration = expiration;
    }
}
