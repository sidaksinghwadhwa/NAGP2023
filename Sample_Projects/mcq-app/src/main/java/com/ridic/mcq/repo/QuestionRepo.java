package com.ridic.mcq.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.ridic.mcq.model.Question;
import com.ridic.mcq.repo.explicit.ExplicitQuestionRepo;

public interface QuestionRepo extends JpaRepositoryImplementation<Question, Integer>, ExplicitQuestionRepo{

}
