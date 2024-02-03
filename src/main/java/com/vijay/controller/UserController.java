package com.vijay.controller;

import com.vijay.entities.UserDtlsEntity;
import com.vijay.helper.EmailUtils;
import com.vijay.model.LoginForm;
import com.vijay.model.ResetPwdForm;
import com.vijay.model.SignUpForm;
import com.vijay.model.UnlockForm;
import com.vijay.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private HttpSession session;


    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginForm",new LoginForm());
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model){
        System.out.println(loginForm);
        String status = userService.login(loginForm);
        if(status.contains("success")){

            return "redirect:/dashboard";

        }
        model.addAttribute("errMsg",status);
        return "login";
    }
    




    @PostMapping("/signup")
    public String handleSingUp(@ModelAttribute("user") SignUpForm form, Model model){
        boolean status = userService.signUp(form);
        if(status){
            model.addAttribute("succMsg", "Account Created, Check your mail");

        }else{
            model.addAttribute("errMsg","Please Enter unique Email Id..!");
        }
        return "signup";
    }


    @GetMapping("/signup")
    public String signUpPage(Model model){
        model.addAttribute("user", new SignUpForm());
        return "signup";
    }
    @GetMapping("/unlock")
    public String unlockPage(@RequestParam String email,Model model){
        UnlockForm unlockForm=new UnlockForm();
        unlockForm.setEmail(email);
        model.addAttribute("unlock",unlockForm);
        return "unlock";
    }
    @PostMapping("/unlock")
    public String unlockUserAccount(@ModelAttribute("unlock") UnlockForm unlock, Model model){
        if(unlock.getNewPwd().equals(unlock.getConfirmPwd())){
            boolean status = userService.unlockAccount(unlock);
            if(status){
               model.addAttribute("succMsg","You account unlocked successfully !");
            }else{
                model.addAttribute("errMsg","Given Temporary password in incorrect !");
            }
        }else {
            model.addAttribute("errMsg","New pwd and Confirm pwd should be same");
        }
        return "unlock";

    }
    @GetMapping("/forgot")
    public String forgotPwdPage(){
        return "forgotPwd";
    }
    @PostMapping("/forgotPwd")
    public String forgotPwd(@RequestParam("email") String email, Model model){
        boolean status= userService.forgotPwd(email);
        if(status){
            model.addAttribute("succMsg","Password send to your email !");
        }else{
            model.addAttribute("errMsg","Please enter valid email id !");
        }
        return "forgotPwd";
    }

    @GetMapping("/resetPwd")
    public String resetPwdPage(@RequestParam String email, Model model){
        ResetPwdForm resetPwdForm = new ResetPwdForm();
        resetPwdForm.setEmail(email);
        model.addAttribute("resetForm", resetPwdForm);
        return "resetPwd";
    }
    @PostMapping("/resetPwd")
    public String resetPwd(@ModelAttribute("resetForm") ResetPwdForm resetForm, Model model){
        if(resetForm.getNewPwd().equals(resetForm.getConfirmPwd())){
            boolean status= userService.resetPwd(resetForm);
            if(status){
                model.addAttribute("succMsg","Password updated successfully !");
            }else{
                model.addAttribute("errMsg","Your Old password is incorrect !");
            }
        }else {
            model.addAttribute("errMsg","New pwd and Confirm pwd should be same");

        }

        return "resetPwd";
    }

}
