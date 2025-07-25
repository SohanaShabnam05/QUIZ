package com.sohana.quizapp.service;

import com.sohana.quizapp.dao.QuestionDao;
import com.sohana.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<QuestionModel>> getAllQuestion() {

        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<QuestionModel> getAllQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(QuestionModel questionModel) {
        System.out.println("Saving question: " + questionModel); // Log input
        questionDao.save(questionModel);
        return "Success";
    }

    public String deleteQuestion(Integer id)
    {
        if(!questionDao.existsById(id))
        {
            return "Question with ID" + id + " does not exist. ";
        }
        questionDao.deleteById(id);
        return "Question Deleted successfully";
    }
}
