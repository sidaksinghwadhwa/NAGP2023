package com.ridic.mcq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridic.mcq.model.Option;
import com.ridic.mcq.model.Question;
import com.ridic.mcq.repo.OptionRepo;
import com.ridic.mcq.repo.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public void createQuestion(Question question) {
		questionRepo.createQuestion(question);
	}

	@Override
	public List<Question> getQuestions() {
		return questionRepo.getQuestions();
	}

}
