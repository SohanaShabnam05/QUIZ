package com.sohana.quizapp.dao;

import com.sohana.quizapp.model.QuizModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<QuizModel, Integer> {
}
