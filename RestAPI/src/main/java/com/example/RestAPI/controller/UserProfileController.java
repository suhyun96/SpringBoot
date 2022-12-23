package com.example.RestAPI.controller;


import com.example.RestAPI.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 해당 클래스는 컨트롤러이며 자동으로 인스턴스 생성
@RestController
public class UserProfileController {
    private Map<String, UserProfile> userMap;

    // 스프링 프레임워크가 컨트롤러 인스턴스 생성시 초기화 해줌
    @PostConstruct
    private void init() {
        userMap = new HashMap<String, UserProfile>();
        userMap.put("1", new UserProfile("1", "홍길동", "111-1111", "서울시 강남구 대치동1"));
        userMap.put("2", new UserProfile("2", "홍길동", "111-1112", "서울시 강남구 대치동2"));
        userMap.put("3", new UserProfile("3", "홍길동", "111-1113", "서울시 강남구 대치동3"));
        System.out.println(userMap);
    }

    /*
     * get : 데이터 조회
     * post : 데이터 수정
     * put : 데이터 생성
     * delete : 데이터 삭제
     * */

    // @PathVariable("id") 요 아이디가 path에 있는 id로 파라미터로 가져오도록 함
    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        // UserProfile 객체 리턴하면 자동으로 JSON형태로 만들어줌
        return userMap.get(id);
    }

    @GetMapping("user/all")
    public List<UserProfile> getUserProfileList() {
        //맵에 있는 리스트를 array value로 리턴
        return new ArrayList<UserProfile>(userMap.values());
    }

    // put 같은 거는 브라우저말고 postman같은 툴을 쓰자
    @PutMapping("/user/{id}")
    // http 형태의 파라미터로 값 전달
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        // 데이터 생성시 패스로 아이디 받고 , 파라미터로 나머지 값을 받네
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        //위에서 만든 객체 추가
        userMap.put(id, userProfile);
    }

    //수정
    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        //얘는 수정용임
        UserProfile userProfile = userMap.get(id);
        userProfile.setName(name);
        userProfile.setPhone(phone);
        userProfile.setAddress(address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id){
        userMap.remove(id);
    }

}

