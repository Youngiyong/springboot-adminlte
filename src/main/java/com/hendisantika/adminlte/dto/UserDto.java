package com.hendisantika.adminlte.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


public class UserDto {

    @Getter
    public static class RequestUser {
        private String email;
        private String password;
        private String auth;
    }

    @Getter
    public static class RequestUpdateUser {
        private String name;
    }

    @Getter
    @AllArgsConstructor
    public static class ResponseCreate {
        private Long id;
        private int returnCode;
        private String returnMessage;
    }

    @Getter
    @AllArgsConstructor
    public static class BaseResponse {
        private int returnCode;
        private String returnMessage;
    }
}
