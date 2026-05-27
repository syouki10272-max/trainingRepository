package com.example.controller;
import com.example.service.Login;

public class LoginController {

    private final Login loginService;

    public LoginController(Login loginService) {
        this.loginService = loginService;
    }

    public String showLoginForm() {
        return "login";
    }

    public String login(String userId, String password) {
        // ログイン処理の実装
        if (loginService.authenticate(userId, password)) {
            return "loginSuccess";
        } else {
            return "loginFailure";
        }
    }
}