package com.example.demo.dto;

import com.example.demo.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberInfoDto {
    private int id;
    private String name;
    private String password;

    @Builder
    public MemberInfoDto(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public static MemberInfoDto of(MemberEntity memberEntity) {
        return  MemberInfoDto.builder()
               .id(memberEntity.getId())
               .name(memberEntity.getName())
               .password(memberEntity.getPassword())
               .build();
    }
}
