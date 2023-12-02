package com.example.sbb.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {

    @Id // 고유번호 id 속성 지정 , 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터 저장시 1씩 자동 증가 옵션 고유번호 생성용
    private Integer id;

    @Column(length = 200) // 글자 수 제한
    private String subject;

    @Column(columnDefinition = "TEXT") // 글자 수 제한 없음
    private String content;

    private LocalDateTime createDate;

    // 질문과 답변은 1:n
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    private LocalDateTime modifyDate;
}
