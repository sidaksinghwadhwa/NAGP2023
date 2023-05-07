package com.official.flight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping
    public ResponseEntity<String> app() {

        return ResponseEntity.ok("Flight App is Up and Running");
    }

}
