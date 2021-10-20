package org.example.controller;

import org.example.dto.LoginDto;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/sign-up")
    public UserDto signUp(@RequestBody User user) {
       return loginService.signUp(user);
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestBody LoginDto loginDto) {
        return loginService.signIn(loginDto);
    }
}
