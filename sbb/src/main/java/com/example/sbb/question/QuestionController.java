package com.example.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// questionRepository 속성 포함하는 생성자 생성
// final 붙은 속성을 포함하는 생성자 자동 생성 즉 questionRepository 객체가 자동 주입 -> 권장방식!!!!
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;
    @GetMapping("/question/list")
   // @ResponseBody
    public String list(Model model){
        List<Question> questionList = this.questionRepository.findAll();
        // model 객체는 자바 클래스와 템플릿간 연결고리 !
        // model에 값을 담아두면 템플리셍서 그 값 사용 가능  -> 객체 생성 불필요 컨트롤러 메서드에 매개변수 지정하면 자동 모델 객체 생성
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
