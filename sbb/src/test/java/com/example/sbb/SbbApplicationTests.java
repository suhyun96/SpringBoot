package com.example.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.sbb.answer.Answer;
import com.example.sbb.answer.AnswerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// 테스트 클래스임을 정의
@SpringBootTest
@WebAppConfiguration
class SbbApplicationTests {

    @Test
    void contextLoads() {
    }

    // DI 기능 객체를 스프링이 자동으로 생성해주고 생성해줌
    // 테스트는 Autowaired 쓰고 실제는 생성자를 통한 객체 주입 방식을 씀
    @Autowired
    private QuestionRepository questionRepository;

    // 객체 주입
    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testJpa() {
        Question q1 = new Question();
        q1.setSubject("sbb란? ");
        q1.setContent("sbb 개념과 구조에 대해서 알고 싶습니다");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("스프링 부트란? ");
        q2.setContent("id는 자동 생성되나요? ");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);

    }

    @Test
    void testJpaFindAll() {
        // findAll 은 jpa가 가지고 있네 -> 데이터 조회시 사용
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb란? ", q.getSubject());

    }

    @Test
    void testJpaFindBySubject() {
        Question q = this.questionRepository.findBySubject("스프링 부트란? ");
        assertEquals(2, q.getId());
    }

    @Test
    void testJpaFindById() {
        //findById - JPA
        //Optional 쓰는 이유는 nnull처리르 유연하게 처리하기 위해서
        Optional<Question> oq = this.questionRepository.findById(1);
        if (oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb란? ", q.getSubject());
        }
    }

    @Test
    void testJpaSubjectAndContent() {
        Question q = this.questionRepository.findBySubjectAndContent(
                "스프링 부트란? ", "id는 자동 생성되나요? "
        );
        assertEquals(2, q.getId());
    }

    @Test
    void testJpaSubjectLike() {
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        Question q = qList.get(0);
        assertEquals("sbb란? ", q.getSubject());
    }

    @Test
    void testUpdate() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }

    @Test
    void testDelete() {
        assertEquals(2, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1, this.questionRepository.count());

    }

    @Test
    void createAnswer(){
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q); // 어떤 질문의 답변인지 알기 위해 필요
        q.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }

    @Test
    void selectAnswer(){
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2,a.getQuestion().getId());
    }

    //질문에서 답변 찾기
    @Test
    @Transactional
    void selectQuestionToAnswer(){
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        // 여기서 Question 객체 받은 후 세션잉 끊김 -> 테스트에서만 !
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1,answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());

    }




}
