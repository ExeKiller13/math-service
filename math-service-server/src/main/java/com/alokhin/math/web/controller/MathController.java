package com.alokhin.math.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alokhin.math.service.MathService;

@Controller
@RequestMapping ("/math")
public class MathController {

    private static final Logger logger = LoggerFactory.getLogger(MathController.class);

    private final MathService mathService;

    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping ("/cos/sequence")
    public ResponseEntity<?> cosSequence(@RequestParam Integer n) {
        try {
            if (n.intValue() <= 0) {
                throw new Exception("Not valid n param");
            }
            return ResponseEntity.ok(mathService.generateSequence(n));
        } catch (Exception e) {
            logger.error("Sequence with n={} param couldn't be calculated", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
