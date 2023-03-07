package com.example.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// 경로 시작점 지정
@RequestMapping("v1")
public class CoffeeV1 {

    @GetMapping("/coffee")
    public String doCoffee(){
        return "/v1/coffee";
    }

}
