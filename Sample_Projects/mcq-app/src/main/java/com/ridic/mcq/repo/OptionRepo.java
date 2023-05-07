package com.ridic.mcq.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.ridic.mcq.model.Option;
import com.ridic.mcq.repo.explicit.ExplicitOptionRepo;

public interface OptionRepo extends JpaRepositoryImplementation<Option, Integer>, ExplicitOptionRepo{

}
