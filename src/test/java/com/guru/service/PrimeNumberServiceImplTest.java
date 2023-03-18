package com.guru.service;

import com.guru.model.PrimeNumbersDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PrimeNumberServiceImplTest {

    public static PrimeNumberService primeNumberService;

    @BeforeAll
    public static void setUp() {
        primeNumberService = new PrimeNumberServiceImpl();
    }

    @Test
    void testPrimesMethodWith10() {
        PrimeNumbersDto primes = primeNumberService.getPrimes(10);
        assertNotNull(primes);
        assertEquals(4, primes.getPrimes().size());
    }

    @Test
    void testPrimesMethodWith0() {
        PrimeNumbersDto primes = primeNumberService.getPrimes(0);
        assertNotNull(primes);
        assertEquals(0, primes.getPrimes().size());
    }

    @Test
    void testPrimesMethodWith1() {
        PrimeNumbersDto primes = primeNumberService.getPrimes(0);
        assertNotNull(primes);
        assertEquals(0, primes.getPrimes().size());
    }
}