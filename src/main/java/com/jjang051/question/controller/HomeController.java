package com.jjang051.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/","/index","/main"})
    public String home() {
        return "index/index";
    }
}
