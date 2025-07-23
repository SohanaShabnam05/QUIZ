package com.sohana.quizapp;

//here i want to accept the request

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question") // added forward slash for clarity
public class QuestionController {

    @GetMapping("/allQuestions") // added forward slash
    public String getAllQuestion() {
        return "Hi, here are your question";
    }
}