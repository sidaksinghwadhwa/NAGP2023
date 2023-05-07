package com.ridic.mcq.repo.explicit;

import java.util.List;

import javax.transaction.Transactional;

import com.ridic.mcq.model.Option;

public interface ExplicitOptionRepo  {

	@Transactional
	void createOption(Option option);
	
	List<Option> getOptions();
}
