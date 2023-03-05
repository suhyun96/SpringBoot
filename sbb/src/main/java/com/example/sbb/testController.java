package com.example.sbb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/test")
public class testController {

/*    @PostMapping(path = "/post1")
    public String testPost(Map<String,String> query){
        StringBuilder sb =new StringBuilder();
        query.entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + " = " +entry.getValue()+"\n");
            sb.append(entry.getKey() + " = " + entry.getValue()+"\n");

        });
        return sb.toString();
    }*/

    //https://bkjo94.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8Spring-Boot%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-POST-REST-API-%EA%B5%AC%ED%98%84

    @PostMapping(path="/post2")
    public String testpost2(@RequestBody User user){
        System.out.println(user.getName());
        System.out.println(user.getAddress());
        System.out.println(user.getAge());
        return user.toString();
    }
}

