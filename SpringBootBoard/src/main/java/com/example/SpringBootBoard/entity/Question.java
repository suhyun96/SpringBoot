package com.example.SpringBootBoard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity //jpa가 엔티티로 인식해주기 위해서
public class Question {
    @Id // 기본키 지정 -> db상 동일값 x = primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터 저장씩 1씩 자동 증가
    private Integer id;

    @Column(length = 200) // 테이블 컬럼명이랑 속성이랑 일치 시킬때 사용
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    // createDate 카멜케이스는 실제 데이터베이스 상으로는 create_date형식으로 구분되어 실제 컬럼명으로 변함
    private LocalDateTime createDate;

    // 질문 입장에서는 질문 : 답변 = 1 : many
    // mappedBy : 참조 엔티티의 속성명 : Answer엔티티에서 Questin엔티티 참조하는 속성명이 question
    // remove : 질문 삭제시 관련된 답변듦 모두 삭제되는 옵션
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

}