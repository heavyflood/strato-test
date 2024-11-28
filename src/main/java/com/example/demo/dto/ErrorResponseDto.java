package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class ErrorResponseDto<T> {
    private final int resultCode;
    private final String resultMessage;
    private final T data;
}
