package com.jjang051.question.controller;

import com.jjang051.question.entity.Question;
import com.jjang051.question.service.AnswerService;
import com.jjang051.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
@Slf4j
public class AnswerController {

    private final AnswerService answerService;
    private final QuestionService questionService;

    @PostMapping("/insert/{id}")
    public String insert(@PathVariable("id") Integer id, @RequestParam String content) {
        Question question = questionService.getQuestion(id);
        //컬럼이 하나 더 생겼다 여기에 데이터 넣어줘야 한다.
        answerService.insert(content,question); //teatarea에서 들어온 값이 넘어간다
        return "redirect:/question/detail/"+id;
    }

}
