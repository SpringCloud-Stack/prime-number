package com.guru.controller;

import com.guru.model.PrimeNumbersDto;
import com.guru.service.PrimeNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PrimeNumbersController {

    private PrimeNumberService primeNumberService;

    public PrimeNumbersController(PrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
    }

    @GetMapping("/{initialValue}")
    public ResponseEntity<PrimeNumbersDto> getPrimes(@PathVariable("initialValue") Integer initialValue) {
        return ResponseEntity.ok(primeNumberService.getPrimes(initialValue));
    }
}
