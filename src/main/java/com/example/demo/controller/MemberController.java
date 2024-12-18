package com.example.demo.controller;

import com.example.demo.config.GeneralException;
import com.example.demo.dto.LoginResultDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.MemberEntity;
import com.example.demo.enumeration.ResultCodeEnum;
import com.example.demo.service.MemberService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/member/info")
    public ResponseDto<MemberDto> getMemberInfo(@RequestBody MemberDto.MemberRequestDto req) {
        MemberEntity entity =
                Optional.ofNullable(memberService.getMemberById(req.getId()))
                    .orElseThrow(() -> new GeneralException(ResultCodeEnum.MemberNotFound));

        return ResponseDto.of(
                ResultCodeEnum.SUCCESS.getCode()
                ,ResultCodeEnum.SUCCESS.getMessage()
                ,MemberDto.of(entity));
    }

    @PostMapping("/member/login")
    public ResponseDto<LoginResultDto> loginMember(@RequestBody MemberDto.MemberLoginRequestDto req) {
        MemberEntity entity =
                Optional.ofNullable(memberService.getMemberById(req.getId()))
                       .filter(e -> e.getPassword().equals(req.getPassword()))
                       .orElseThrow(() -> new GeneralException(ResultCodeEnum.LoginFAILED));
        String token= JwtUtil.generateToken(MemberDto.of(entity));
        return ResponseDto.of(
                ResultCodeEnum.SUCCESS.getCode()
                , ResultCodeEnum.SUCCESS.getMessage()
                , LoginResultDto.builder()
                       .token(token)
                    .expiration(JwtUtil.getExpireDate(token))
                       .member(MemberDto.of(entity))
                       .build());
    }

    @PostMapping("/member/register")
    public ResponseDto<MemberDto> registerMember(@RequestBody MemberDto.MemberInsertRequestDto req) {
        MemberEntity entity = MemberDto.memberInsertRequestDtoEntity(req);
        memberService.insertMember(entity);
        MemberDto memberDto = MemberDto.of(Optional.ofNullable(memberService.getMemberById(entity.getId()))
                .orElseThrow(() -> new GeneralException(ResultCodeEnum.MemberNotFound)));
        return ResponseDto.of(
                ResultCodeEnum.SUCCESS.getCode()
                , ResultCodeEnum.SUCCESS.getMessage()
                , memberDto);
    }
}
