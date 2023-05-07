package com.official.notification.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping
    public ResponseEntity<String> app() {

        return ResponseEntity.ok("Payment App is Up and Running");
    }

}
