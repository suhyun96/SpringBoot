package com.example.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
        // 리다이렉트로
    }
}
