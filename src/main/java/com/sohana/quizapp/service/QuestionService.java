package com.sohana.quizapp.service;

import com.sohana.quizapp.dao.QuestionDao;
import com.sohana.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<QuestionModel> getAllQuestion() {
        return questionDao.findAll();
    }

    public List<QuestionModel> getAllQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(QuestionModel questionModel) {
        System.out.println("Saving question: " + questionModel); // Log input
        questionDao.save(questionModel);
        return "Success";
    }
}
