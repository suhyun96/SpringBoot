package com.example.sbb.answer;

import com.example.sbb.question.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // 질문 엔티티와 연결된 속성이라는 걸 표시해야함
    // 하나의 질문에 답변 여러개 달림 - 외래키 형성됨
    @ManyToOne
    private Question question;
}
