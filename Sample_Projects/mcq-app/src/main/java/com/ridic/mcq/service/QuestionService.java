package com.ridic.mcq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ridic.mcq.model.Option;
import com.ridic.mcq.model.Question;

public interface QuestionService {

	void createQuestion(Question question);

	List<Question> getQuestions();
}
