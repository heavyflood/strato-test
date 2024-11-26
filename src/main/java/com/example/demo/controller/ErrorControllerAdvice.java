package com.example.demo.controller;

import com.example.demo.dto.ResponseDto;
import com.example.demo.enumeration.ResultCodeEnum;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.MethodNotAllowedException;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseDto<Object> handleNotFoundException(Exception ex) {
        int code = HttpStatus.NOT_FOUND.value();
        return ResponseDto.of(
                String.valueOf(code)
                , ResultCodeEnum.getEnum(code).getMessage()
                , null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseDto<Object> handleException(Exception ex) {
        int code = HttpStatus.BAD_REQUEST.value();
        return ResponseDto.of(
                String.valueOf(code)
                , ResultCodeEnum.getEnum(code).getMessage()
                , null);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    protected ResponseDto<Object> handleMethodNotAllowedException(MethodNotAllowedException ex) {
        int code = HttpStatus.METHOD_NOT_ALLOWED.value();
        return ResponseDto.of(
                String.valueOf(code)
               , ResultCodeEnum.getEnum(code).getMessage()
               , null);
    }




}
