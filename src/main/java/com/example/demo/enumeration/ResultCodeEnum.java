package com.example.demo.enumeration;

public enum ResultCodeEnum {
    SUCCESS(200, "Success"),
    ServerErrorFAILED(500, "Server Error"),
    BadRequestFAILED(400, "Bad Request"),
    NotFoundFAILED(404, "Not Found"),
    UnauthorizedFAILED(401, "Unauthorized"),
    ForbiddenFAILED(403, "Forbidden"),
    MethodNotAllowedFAILED(405, "Method Not Allowed"),
    MemberNotFound(40001, "Member Not Found");

    private int code;
    private String message;

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResultCodeEnum getEnum(int code) {
        for (ResultCodeEnum result : ResultCodeEnum.values()) {
            if (result.getCode() == code) {
                return result;
            }
        }
        return null;
    }
}
