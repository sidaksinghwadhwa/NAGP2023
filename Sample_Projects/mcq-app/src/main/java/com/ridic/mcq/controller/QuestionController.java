package com.ridic.mcq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridic.mcq.constants.MainConstants;
import com.ridic.mcq.model.Question;
import com.ridic.mcq.service.QuestionService;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/")
	public ResponseEntity<List<Question>> getAll() {
		return ResponseEntity.ok(questionService.getQuestions());
	}
	
	@PostMapping("/")
	public ResponseEntity<String> create() {
		Question question1 = new Question();
		question1.setDomain("ART");
		question1.setHasImage(false);
		question1.setHasMultipleAnswers(false);
		question1.setText("Leonardo Da Vinci's Famous Art ?");
		
		questionService.createQuestion(question1);

		return ResponseEntity.ok(MainConstants.QUESTION_CREATED);
	}
}
