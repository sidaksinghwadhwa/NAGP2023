package com.ridic.mcq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridic.mcq.model.Option;
import com.ridic.mcq.repo.OptionRepo;

@Service
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionRepo optionRepo;
	
	@Override
	public void createOption(Option option) {
		optionRepo.createOption(option);
	}

	@Override
	public List<Option> getOptions() {
		return optionRepo.getOptions();
	}

}
