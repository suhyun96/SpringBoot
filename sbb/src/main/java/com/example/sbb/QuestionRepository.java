package com.example.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

//레포지토리 만들기 위해서 JpaRepositry 인터페이스 상속
//JpaRepositry 상속시 대상이 되는 엔티티 와 PK속성 넣어줘야함 ! = 규칙
public interface QuestionRepository extends JpaRepository<Question , Integer> {

    // subject로 데이터 조회
    Question findBySubject(String subject);

    Question findBySubjectAndContent(String subject , String content);

}
