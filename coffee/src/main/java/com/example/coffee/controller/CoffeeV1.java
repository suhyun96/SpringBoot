package com.example.coffee.controller;

import com.example.coffee.service.CoffeeV1Service;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
// 경로 시작점 지정
@RequestMapping("v1")
// 롬복 로그 ?
@Log4j2
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


    @PostMapping("/coffee")
    public String doCoffeePost(HttpServletRequest request, Model model){
        // html form으로 받은 리퀘스트 항목의 값을 추출

        String strStart_date = request.getParameter("start_date");
        String strEnd_date = request.getParameter("end_date");
        String strName = request.getParameter("name");
        log.info(strName);
        String strKind = request.getParameter("kind");
        // 이걸로 터미널창에 로그 확인 가능
        log.info(strKind);


        // 전체 리스트 조회 오보로딩
        List<Map<String,String>> list = coffeeV1Service.doCoffeeList(strStart_date,strEnd_date,strName,strKind);
        model.addAttribute("list",list);

        return "/v1/coffee";
    }

}
