package com.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// questionRepository 속성 포함하는 생성자 생성
// final 붙은 속성을 포함하는 생성자 자동 생성 즉 questionRepository 객체가 자동 주입 -> 권장방식!!!!
@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

    //리포지토리 삭제
   // private final QuestionRepository questionRepository;

    // 리포지토리 대신 서비스로 불러서 모듈화 -> 서비스가 컨트롤의 일을 대신 하도록
    private final QuestionService questionService;
    @GetMapping("/list")
   // @ResponseBody
    public String list(Model model){
        List<Question> questionList = this.questionService.getList();
        // model 객체는 자바 클래스와 템플릿간 연결고리 !
        // model에 값을 담아두면 템플리셍서 그 값 사용 가능  -> 객체 생성 불필요 컨트롤러 메서드에 매개변수 지정하면 자동 모델 객체 생성
        model.addAttribute("questionList", questionList);
        return "question_list";
    }


    @GetMapping(value = "/detail/{id}")
    public String detail(Model model , @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }
}
