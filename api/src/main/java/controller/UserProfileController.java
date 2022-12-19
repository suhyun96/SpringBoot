package controller;

import model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

// 해당 클래스는 컨트롤러이며 자동으로 인스턴스 생성
@Controller
public class UserProfileController {
    private Map<String, UserProfile> userMap;

    // 스프링 프레임워크가 컨트롤러 인스턴스 생성시 초기화 해줌
    @PostConstruct
    private void init(){
        userMap = new HashMap<String, UserProfile>();
        userMap.put("1",new UserProfile("1","홍길동","111-1111","서울시 강남구 대치동1"));
        userMap.put("2",new UserProfile("2","홍길동","111-1112","서울시 강남구 대치동2"));
        userMap.put("3",new UserProfile("3","홍길동","111-1113","서울시 강남구 대치동3"));
        System.out.println(userMap);
    }


    @GetMapping("/user/{id}")
    // @PathVariable("id") 요 아이디가 path에 있는 id로 파라미터로 가져오도록 함
    public UserProfile getUserProfile(@PathVariable("id") String id){
        // UserProfile 객체 리턴하면 자동으로 JSON형태로 만들어줌
        System.out.println("hello");
        return userMap.get(id);
    }


    @GetMapping("/")
    // @PathVariable("id") 요 아이디가 path에 있는 id로 파라미터로 가져오도록 함
    public void main(){
        System.out.println(userMap);

    }
}
