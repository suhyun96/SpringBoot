package com.example.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    // request가 여러개 올 때 {} 로 받을 수 있도록 설정 가능
    @GetMapping({"/","/home"})
    public String doHome(){
        // root path는 template 기준
        return "/home/home";
    }

}
