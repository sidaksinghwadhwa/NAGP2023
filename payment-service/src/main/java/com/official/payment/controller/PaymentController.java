package com.official.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/pay")
    public ResponseEntity<Boolean> pay(@RequestParam("bookingAmount") Double bookingAmount,
            @RequestParam("paid") Boolean paid) {

        return ResponseEntity.ok(Boolean.valueOf(paid));

    }

    @GetMapping("/refund")
    public ResponseEntity<Boolean> refund(@RequestParam("bookingId") Integer bookingId,
            @RequestParam("refundAmount") Double refundAmount,
            @RequestParam("refunded") Boolean refunded) {

        return ResponseEntity.ok(Boolean.valueOf(refunded));

    }
}
