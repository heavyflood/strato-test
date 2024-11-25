package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.MemberInfoDto;
import com.example.demo.entity.MemberEntity;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/info")
    public MemberInfoDto getMemberInfo(@RequestBody MemberDto member) {
        int memberId = member.getId();
        MemberEntity returnMember = memberService.getMemberById(memberId);
        MemberInfoDto toDto = MemberInfoDto.of(returnMember);
        return toDto;
    }
}
