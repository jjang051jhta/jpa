package com.jjang051.question.controller;

import com.jjang051.question.dto.CustomUserDetails;
import com.jjang051.question.entity.Question;
import com.jjang051.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/dummy-list")
    @ResponseBody
    public String dummy() {
        questionService.insertQuestion();
        return "dummy";
    }
    @GetMapping("/list")
    public String list(Model model,
                 @RequestParam(value="page",defaultValue = "0") int page) {
        //List<Question> questionList = questionService.getList();
        Page<Question> pageList = questionService.getList(page); //시작은 0
        log.info("pageList==={}",pageList.getSize());
        model.addAttribute("questionList",pageList);
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
