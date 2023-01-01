package com.example.sbb.question;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

// 생성자 방식으로 DI규칙 만듦
@RequiredArgsConstructor
// 어노테이션으로 서비스 인식
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }
}
