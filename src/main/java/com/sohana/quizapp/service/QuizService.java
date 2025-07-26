package com.sohana.quizapp.service;

import com.sohana.quizapp.dao.QuestionDao;
import com.sohana.quizapp.dao.QuizDao;
import com.sohana.quizapp.model.QuestionModel;
import com.sohana.quizapp.model.QuizModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<QuestionModel> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        QuizModel quizModel = new QuizModel();
        quizModel.setTitle(title);
        quizModel.setQuestions(questions);
        quizDao.save(quizModel);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }



}
