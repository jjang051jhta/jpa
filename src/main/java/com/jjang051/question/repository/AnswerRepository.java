package com.jjang051.question.repository;

import com.jjang051.question.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
