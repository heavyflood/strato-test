package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
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
    public MemberDto getMemberInfo(@RequestBody MemberDto.MemberRequestDto req) {
        int memberId = req.getId();
        MemberEntity returnMember = memberService.getMemberById(memberId);
        MemberDto toDto = MemberDto.of(returnMember);
        return toDto;
    }
}
