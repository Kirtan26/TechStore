//package net.loginSignUp.controller;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@Controller
//@ControllerAdvice
//public class DemoController {
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handleException(Exception e, Model model) {
//        model.addAttribute("error", e.getMessage()); // Pass the error message to the view
//        return "access-denied"; // Name of your custom error view template
//    }
//}
