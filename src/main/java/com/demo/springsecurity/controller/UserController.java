package com.demo.springsecurity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/info")
    public String info(@AuthenticationPrincipal User user) {
                    //인증에 성공하면 인증한 사용자 정보를 리턴받음
        return user.getUsername();
    }
}
