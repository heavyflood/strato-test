package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.enumeration.ResultCodeEnum;
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
    public ResponseDto<MemberDto> getMemberInfo(@RequestBody MemberDto.MemberRequestDto req) {
        MemberDto toDto = MemberDto.of(memberService.getMemberById(req.getId()));
        return ResponseDto.of(String.valueOf(ResultCodeEnum.getEnum(200).getCode())
                ,ResultCodeEnum.getEnum(200).getMessage()
                ,toDto);
    }
}
