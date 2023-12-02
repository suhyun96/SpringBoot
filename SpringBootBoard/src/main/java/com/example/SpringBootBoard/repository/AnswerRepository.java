package com.example.SpringBootBoard.repository;

import com.example.SpringBootBoard.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
