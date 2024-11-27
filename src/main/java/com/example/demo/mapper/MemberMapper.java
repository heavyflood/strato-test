package com.example.demo.mapper;

import com.example.demo.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    MemberEntity getMemberById(int id);
    int insertMember(MemberEntity memberEntity);
}
