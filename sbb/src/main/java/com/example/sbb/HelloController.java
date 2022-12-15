package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//요청이 올 때 프레임워크가 해당 클래스를 컨트롤러라고 인식하도록 선언
@Controller
public class HelloController {
    //Get요청에서 "/hello"가 오면 이 밑의 메소드를 실행
    @GetMapping("/hello")
    //hello() 리턴값이 요청에 응답값이라고 알려줌 보통 html파일 씀
    @ResponseBody
    public String hello(){
        return "Hello World!!!!";
    }
}
