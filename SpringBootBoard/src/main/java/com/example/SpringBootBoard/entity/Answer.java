package com.example.SpringBootBoard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    // 답변은 하나의 질문에 여러개 달리는 구조 답변:질문 = many : one
    // 부모 자식간 관계에 주로 사용 부모 : question , 자식 : asnwer
    @ManyToOne
    private Question question;
}