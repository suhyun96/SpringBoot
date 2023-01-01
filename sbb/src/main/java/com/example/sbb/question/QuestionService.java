package com.example.sbb.question;

import com.example.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 생성자 방식으로 DI규칙 만듦
@RequiredArgsConstructor
// 어노테이션으로 서비스 인식
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

    //id값으로 question 조회 다만 조회했는데 없으면 에러 반환하고 있으면 해당 question객체 반환
    public Question getQuestion(Integer id){
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }
        else {
            throw new DataNotFoundException("qeustin not found");
        }
    }
}
