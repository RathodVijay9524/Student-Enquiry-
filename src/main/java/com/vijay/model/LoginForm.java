package com.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class LoginForm {

    private Integer userId;
    private String email;
    private String pwd;
}
