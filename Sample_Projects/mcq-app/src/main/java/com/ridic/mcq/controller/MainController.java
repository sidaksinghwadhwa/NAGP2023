package com.ridic.mcq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridic.mcq.constants.MainConstants;

@RestController
public class MainController {
	
	@GetMapping("/")
	public ResponseEntity<String> health() {
		return ResponseEntity.ok(MainConstants.HEALTHY_APP);
	}
}
