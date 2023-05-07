package com.ridic.mcq.repo.explicit;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ridic.mcq.model.Option;

@Repository
public class ExplicitOptionRepoImpl implements ExplicitOptionRepo{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void createOption(Option option) {
		entityManager.persist(option);
	}

	@Override
	public List<Option> getOptions() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Option> query = builder.createQuery(Option.class);
		
		Root<Option> from = query.from(Option.class);
	    query.select(from);
	    
		return entityManager.createQuery(query).getResultList();
	}

}
