package com.jjang051.question.service;

import com.jjang051.question.entity.Answer;
import com.jjang051.question.entity.Question;
import com.jjang051.question.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    public void insert(String content, Question question) {
        Answer answer = Answer.builder()
                .content(content)
                .regDate(LocalDateTime.now())
                .question(question)
                .build();
        //Answer answer1 = new Answer();
        answerRepository.save(answer);
    }
}
