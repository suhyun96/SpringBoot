package com.example.sbb.answer;

import com.example.sbb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
// 입력받은 내용과 매핑되는 question을 answer객체에 저장함
public class AnswerService {
    private  final AnswerRepository answerRepository;

    public void create(Question question,String content){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }

}
