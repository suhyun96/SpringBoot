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
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/insert")
    public String doInsert(){
        return "/v1/coffee_Ins";
    }

    // 위에서는 HttpServletRequest request 이걸 받았는데 파라미터 몇 개 안 되면 다 넣어줘도 오케
    // html에 각 name에 적혀있던 태그들의 값을 넣음
    // ex ) <label>가 격 </label><input type="number" name="price"></p> price태그에 있는 값이 들어감
    @PostMapping("/insert")
    public String doInsertPost(@RequestParam(value="name") String name ,@RequestParam(value="kind") String kind ,@RequestParam(value="price") String price, Model model  ){

        log.info(name + kind + price );
        int intI = coffeeV1Service.doInsert(name,kind,price);
        return "redirect:/v1/coffee";
    }

    // 수정하기 get -> 줄 마다 있던 수정
    @GetMapping("/update")
    public String doUpdate(@RequestParam(value="coffee_id") String strCoffee_id , Model model){
        // 맵인 거는 한 줄 그게 map이니까
        Map<String,String> map = coffeeV1Service.doListOne(strCoffee_id);
        model.addAttribute("map",map);

        return "/v1/coffee_Up";
    }

    /* 수정하기 Post , @RequestParam 사용 */
    // 수정하기에서 받은 값을 여기서 다시 처리하고 수정후 리다이렉트해서 화면 표시
    @PostMapping("/update")
    public String doUpdatePost(
            @RequestParam(value="coffee_id") String strCoffee_id,
            @RequestParam(value="name") String strName,
            @RequestParam(value="kind") String strKind,
            @RequestParam(value="price") String strPrice
    ){

        int intI  = coffeeV1Service.doUpdate(strCoffee_id, strName, strKind, strPrice);

        return "redirect:/v1/coffee";
    }

    /* 삭제하기 1 row , @RequestParam 사용  */
    @GetMapping("/delete")
    public String doDelete(@RequestParam(value="coffee_id") String strCoffee_id){

        int intI = coffeeV1Service.doDelete(strCoffee_id);

        return "redirect:/v1/coffee";
    }

}
