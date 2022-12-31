package com.example.sbb.question;

import com.example.sbb.answer.Answer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
// Controller 처럼 Entity 적용시켜야 이게 엔티티인지 앎
@Entity
public class Question {
    //기본키 지정
    @Id
    //따로 저장 안해도 디비가 자동으로 세팅해줌
    // strategy = 고유 번호 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //엔티티 속성 = 컬럼명
    // @Column 없어도 인식은 함 다만 세부설정하기 위함
    @Column(length = 200)
    private String subject;

    // 글자수 제한 없는 경우
    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    // 실제 디비에선 카멜케이스가 아니라 스네이크 형식으로 컬럼들이 만들어짐

    //질문과 답변은 1:n
    //question 하나에 answer 여러개니까 List구성
    //질문 삭제시 답변도 다 같이 삭제 cascade remove
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

}
