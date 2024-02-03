package com.vijay.service;

import com.vijay.entities.UserDtlsEntity;
import com.vijay.model.LoginForm;
import com.vijay.model.ResetPwdForm;
import com.vijay.model.SignUpForm;
import com.vijay.model.UnlockForm;


public interface UserService {


    public String login(LoginForm form);

    public boolean signUp(SignUpForm form);

    public boolean unlockAccount(UnlockForm form);

    public boolean forgotPwd(String email);

    public boolean resetPwd(ResetPwdForm form);

}
