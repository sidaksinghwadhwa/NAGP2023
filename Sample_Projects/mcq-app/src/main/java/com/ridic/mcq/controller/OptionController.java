package com.ridic.mcq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridic.mcq.constants.MainConstants;
import com.ridic.mcq.model.Option;
import com.ridic.mcq.service.OptionService;

@RestController
@RequestMapping(value = "/option")
public class OptionController {
	
	@Autowired
	private OptionService optionService;
	
	@GetMapping("/")
	public ResponseEntity<List<Option>> getAll() {
		return ResponseEntity.ok(optionService.getOptions());
	}
	
	@PostMapping("/")
	public ResponseEntity<String> create() {
		Option option1 = new Option();
		option1.setText("Mona Lisa");
		option1.setIsCorrect(true);
		option1.setQid(1);
		Option option2 = new Option();
		option2.setText("Caprio");
		option2.setIsCorrect(false);
		option2.setQid(1);
		Option option3 = new Option();
		option3.setText("Jordan");
		option3.setIsCorrect(false);
		option3.setQid(1);
		optionService.createOption(option1);
		optionService.createOption(option2);
		optionService.createOption(option3);
		return ResponseEntity.ok(MainConstants.OPTION_CREATED);
	}
}
