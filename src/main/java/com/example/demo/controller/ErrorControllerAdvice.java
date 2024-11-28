package com.example.demo.controller;

import com.example.demo.config.GeneralException;
import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.enumeration.ResultCodeEnum;
import org.apache.coyote.BadRequestException;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDto handleUncaughtException(Exception ex, WebRequest request) {
        int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        return ErrorResponseDto.of(
                code
                , ResultCodeEnum.getEnum(code).getMessage()
                , ex.getMessage());
    }


    @ExceptionHandler(GeneralException.class)
    public ErrorResponseDto<Object> handleGeneralException(GeneralException ex) {
        int code = ex.getResultCode().getCode();
        return ErrorResponseDto.of(
                code
               , ex.getResultCode().getMessage()
               , ex.getMessage());
    }
}
