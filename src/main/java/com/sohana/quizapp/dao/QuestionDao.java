package com.sohana.quizapp.dao;

import com.sohana.quizapp.model.QuestionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<QuestionModel, Integer> {


    List<QuestionModel> findByCategory(String category);

    @Query(value = "SELECT * FROM question_model q WHERE q.category = ?1 ORDER BY RANDOM() LIMIT ?2", nativeQuery = true)
    List<QuestionModel> findRandomQuestionsByCategory(String category, int numQ);

}
