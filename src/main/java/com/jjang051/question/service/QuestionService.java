package com.jjang051.question.service;

import com.jjang051.question.entity.Question;
import com.jjang051.question.exception.DataNotFoundException;
import com.jjang051.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {
    private final QuestionRepository questionRepository;

    //메서드 만들어 쓰기
    public void insert(String subject, String content) {
        //Entity
//        Question question = new Question();
//        question.setSubject(subject);
//        question.setContent(content);
//        question.setRegDate(LocalDateTime.now());
        Question question = Question.builder()
                .subject(subject)
                .content(content)
                .regDate(LocalDateTime.now())
                .build();
        // entity 만 받을 수 있다
        // 영속화 시킨다.  entityManager가 관리하면서 db에 입출력을 해준다.
        // 영속성 context 에서 모든 작업이 이루어진다. 1차 캐쉬   변경감지(dirth checking)
        Question savedQuestion = questionRepository.save(question);
        log.info("question==savedQuestion==={}",question==savedQuestion);

    }

    public List<Question> getList() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        /*
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        }
        log.info("아이디 없음");
        throw new DataNotFoundException("아이디 확인해주세요");
        */
        Question question = questionRepository.findById(id).orElseThrow(
                ()->new DataNotFoundException("아이디 확인해주세요")
        );
        return question;
    }
}