package com.example.StudySpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        // name 파라미터를 모델에 추가
        model.addAttribute("name", name);
        return "hello-template"; // hello-template.html을 반환
    }

}
