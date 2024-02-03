package com.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
public class UnlockForm {
    private String email;
    private String tempPwd;
    private String newPwd;
    private String confirmPwd;
}
