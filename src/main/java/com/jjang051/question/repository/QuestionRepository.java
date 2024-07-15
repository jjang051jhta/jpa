package com.jjang051.question.repository;

import com.jjang051.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    //기본적인 것들은 다 들고 있다
    //필요하면 내가 메서드를 저으이해서 만들어 쓸 수 있다.
    Question findBySubject(String subject);

    //임의로 만든 메서드
    Question findBySubjectAndContent(String subject, String content);
    //데이터를 5개 정도 더 넣고
    List<Question> findBySubjectLike(String subject);
}
