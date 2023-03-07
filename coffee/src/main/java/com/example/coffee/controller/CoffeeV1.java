package com.example.coffee.controller;

import com.example.coffee.service.CoffeeV1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
// 경로 시작점 지정
@RequestMapping("v1")
public class CoffeeV1 {

    // autowired로 서비스 객체 가지고 오기
    @Autowired
    CoffeeV1Service coffeeV1Service;


    @GetMapping("/coffee")
    public String doCoffee(Model model){

        /*전체 리스트 조회*/
        //디비에 있는 값들 한 행을 map 그 묶음을 list로
        List<Map<String,String>> list = coffeeV1Service.doCoffeeList();

        //System.out.println(list);
        //모델에다가 값 넣어주기 이제 웹으로 넘겨줌
        model.addAttribute("list",list);
        return "/v1/coffee";
    }

}
