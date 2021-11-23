package com.hendisantika.adminlte.dto;


import com.hendisantika.adminlte.model.FranchiseeTags;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


public class Dto {

    @Getter
    public static class RequestUser {
        private String email;
        private String password;
        private String roles;
    }

    @Getter
    public static class RequestTag {
        private String name;
    }

    @Getter
    public static class RequestFranchiseeTas {
        private String name;
    }

    @Getter
    public static class RequestFranchisee {
        private String name;
        private String phone;
        private String description;
        private String thumbnail;
        private List<RequestFranchiseeTas> tags;
    }

    @Getter
    public static class RequestCreateFranchiseeTag {
        private String name;
    }

    @Getter
    public static class RequestDeleteFranchiseeTag {
        private Long id;
    }

    @Getter
    public static class RequestUpdateFranchisee {
     private String name;
     private String phone;
     private String description;
     private String thumbnail;
     private List<RequestCreateFranchiseeTag> createFranchiseeTags;
     private List<RequestDeleteFranchiseeTag> deleteFranchiseeTags;
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
