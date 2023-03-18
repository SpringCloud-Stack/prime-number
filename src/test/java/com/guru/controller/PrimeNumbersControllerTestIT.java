package com.guru.controller;

import com.guru.PrimeNumbersApplication;
import com.guru.model.PrimeNumbersDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PrimeNumbersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PrimeNumbersControllerTestIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getPrimes() {
        PrimeNumbersDto primes = this.restTemplate
                .getForObject("http://localhost:" + port + "/api/v1/10", PrimeNumbersDto.class);
        assertNotNull(primes);
        assertTrue(primes.getPrimes().size() > 0);
    }
}