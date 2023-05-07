package com.ridic.mcq.repo.explicit;

import java.util.List;

import javax.transaction.Transactional;

import com.ridic.mcq.model.Question;

public interface ExplicitQuestionRepo  {

	@Transactional
	void createQuestion(Question question);
	
	List<Question> getQuestions();
}
