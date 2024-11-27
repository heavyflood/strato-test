package com.example.demo.config;

import com.example.demo.enumeration.ResultCodeEnum;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {

    private final ResultCodeEnum resultCode;

    public GeneralException(ResultCodeEnum resultCodeEnum) {
        super();
        this.resultCode = resultCodeEnum;
    }
}
