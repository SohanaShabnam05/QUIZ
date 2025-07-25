package com.sohana.quizapp.controller;

//here i want to accept the request

import com.sohana.quizapp.model.QuestionModel;
import com.sohana.quizapp.service.QuestionService;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question") // added forward slash for clarity
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions") // added forward slash
    public ResponseEntity<List<QuestionModel>> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("/category/{category}")
    public List<QuestionModel> getQuestionByCategory(@PathVariable String category)
    {
        return questionService.getAllQuestionsByCategory(category);
    }


    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionModel questionModel) {
        String response = questionService.addQuestion(questionModel);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id)
    {
        String response = questionService.deleteQuestion(id);
        return ResponseEntity.ok(response);
    }
}