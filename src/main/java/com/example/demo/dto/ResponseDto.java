package com.example.demo.dto;

import com.example.demo.enumeration.ResultCodeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class ResponseDto<T> {
    private final String resultCode;
    private final String resultMessage;
    private final T data;
}
