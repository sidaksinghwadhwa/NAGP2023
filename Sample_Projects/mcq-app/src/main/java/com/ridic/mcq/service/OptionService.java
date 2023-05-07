package com.ridic.mcq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ridic.mcq.model.Option;

public interface OptionService {

	void createOption(Option option);

	List<Option> getOptions();
}
