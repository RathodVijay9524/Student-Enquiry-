package com.vijay.model;


import lombok.Data;

@Data
public class ResetPwdForm {


    private String email;
    private String oldPwd;
    private String newPwd;
    private String confirmPwd;
}
