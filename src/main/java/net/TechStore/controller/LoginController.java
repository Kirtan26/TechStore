package net.TechStore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

//    @GetMapping("/login")
//    public String showMyLoginPage(){
//        GlobalData.cart.clear();
//        return "login";
//    }
//
    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "accessDenied";
    }
//
//    @GetMapping("/register")
//    public String register() {
//        return "register";
//    }

//    @GetMapping("/error")
//    public String error() {
//
//        return "accessDenied";
//    }
}
