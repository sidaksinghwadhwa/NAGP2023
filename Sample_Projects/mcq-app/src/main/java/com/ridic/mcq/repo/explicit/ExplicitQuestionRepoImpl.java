package com.ridic.mcq.repo.explicit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ridic.mcq.model.Question;

@Repository
public class ExplicitQuestionRepoImpl implements ExplicitQuestionRepo{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void createQuestion(Question question) {
		entityManager.persist(question);
	}

	@Override
	public List<Question> getQuestions() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Question> query = builder.createQuery(Question.class);
		
		Root<Question> from = query.from(Question.class);
	    query.select(from);
	    
		return entityManager.createQuery(query).getResultList();
	}

}
