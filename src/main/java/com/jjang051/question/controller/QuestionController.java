package com.jjang051.question.controller;

import com.jjang051.question.entity.Question;
import com.jjang051.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/insert")
    public String insert() {
        return "question/insert";
    }

    @PostMapping("/insert")
    public String insertProcess(String subject, String content) {
        // JPA(인터페이스) hibernate  (Spring data jpa)
        // O(Object)R(Relation)M(Mapping)
        //
        questionService.insert(subject,content);
        return "redirect:/question/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList",questionList);
        return "question/list";
    }

    @GetMapping("/detail/{id}")
    public String list(Model model, @PathVariable("id") Integer id) {
        Question question = questionService.getQuestion(id);
        //question.getAnswer().size();
        model.addAttribute("question",question);
        return "question/detail";
    }

}
