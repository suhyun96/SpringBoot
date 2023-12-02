package com.example.SpringBootBoard.repository;


import com.example.SpringBootBoard.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository 상속시 제너릭 타임으로 리포지토리 대상이 되는 Question 그리고 엔티티의 PK속성을 정의
public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
