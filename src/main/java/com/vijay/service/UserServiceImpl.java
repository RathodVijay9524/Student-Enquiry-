package com.vijay.service;

import com.vijay.entities.UserDtlsEntity;
import com.vijay.helper.EmailUtils;
import com.vijay.helper.PwdUtils;
import com.vijay.model.LoginForm;
import com.vijay.model.ResetPwdForm;
import com.vijay.model.SignUpForm;
import com.vijay.model.UnlockForm;
import com.vijay.repo.UserDtlsRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDtlsRepo userDtlsRepo;
    @Autowired
    private EmailUtils emailUtils;

    @Autowired
    private HttpSession session;
    @Override
    public String login(LoginForm form) {

        UserDtlsEntity entity = userDtlsRepo.findByEmailAndPwd(form.getEmail(), form.getPwd());
        if (entity == null) {
            return "Invalid Credentials";
        }
        if (entity.getAccStatus().equals("LOCKED")) {
            return "your Account is Locked, Unlock you account";
        }
        session.setAttribute("userId", entity.getUserId());
        return "success";
    }

    @Override
    public boolean signUp(SignUpForm form) {
        UserDtlsEntity user = userDtlsRepo.findByEmail(form.getEmail());
        if(user!=null){
            return false;
        }
        UserDtlsEntity entity= new UserDtlsEntity();
        BeanUtils.copyProperties(form, entity);
        String tempPwd= PwdUtils.generateRandomPwd();
        entity.setPwd(tempPwd);
        entity.setAccStatus("LOCKED");
        userDtlsRepo.save(entity);
        String to= form.getEmail();
        String subject="Unlock your Account ";
        StringBuffer body=new StringBuffer();
        body.append("<h3> Use below Temporary pwd to unlock you account<h3>");
        body.append("Temporary Password : "+tempPwd);
        body.append("<br/>");

        body.append("<h4><a href=\"http://localhost:9090/unlock?email=" + to +"\"> Click Here to Unlock your Account</a><h4>");
        emailUtils.sendEmail(to, subject, body.toString());
        return true;
    }

    @Override
    public boolean unlockAccount(UnlockForm form) {
        UserDtlsEntity entity= userDtlsRepo.findByEmail(form.getEmail());
        if (entity != null && entity.getPwd().equals(form.getTempPwd())) {
            entity.setPwd(form.getNewPwd());
            entity.setAccStatus("Unlocked");
            String email = entity.getEmail();
            userDtlsRepo.save(entity);
            String subject = "Congratulations! Your Account is Unlocked";
            String body = "You can enroll in any course.<br> We have the best faculty.<br> Thank you.";
            emailUtils.sendEmail(email, subject, body);
            return true;

        }else{
           return false;
        }

    }

    @Override
    public boolean forgotPwd(String email) {
        UserDtlsEntity entity= userDtlsRepo.findByEmail(email);
        if(entity == null){
            return false;
        }
        String subject=" Recover Email !";
        String body = "Your Password id :: "+ entity.getPwd();
        emailUtils.sendEmail(email,subject,body);
        return true;
    }

    @Override
    public boolean resetPwd(ResetPwdForm form) {
        UserDtlsEntity entity= userDtlsRepo.findByEmail(form.getEmail());
        if(entity.getPwd().equals(form.getOldPwd())){
            entity.setPwd(form.getNewPwd());
            userDtlsRepo.save(entity);
            return true;
        }
        return false;
    }

}
