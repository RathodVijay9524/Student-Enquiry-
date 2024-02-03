package com.vijay.model;

import lombok.Data;


@Data
public class SignUpForm {

    private Integer userId;
    private String name;
    private String email;
    private Long phoNo;

}
