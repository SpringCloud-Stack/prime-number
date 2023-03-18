package com.guru.service;

import com.guru.model.PrimeNumbersDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {
    @Override
    @Cacheable("primes")
    public PrimeNumbersDto getPrimes(int initialValue) {
        List<Integer> primes = IntStream.rangeClosed(1, initialValue).parallel()
                .filter(PrimeNumberServiceImpl::isPrime)
                .boxed()
                .collect(Collectors.toList());
        return transform(initialValue, primes);
    }

    private static boolean isPrime(int initialValue) {
        return initialValue > 1 && IntStream.rangeClosed(2, initialValue / 2).noneMatch(i -> initialValue % i == 0);
    }

    private static PrimeNumbersDto transform(int initialValue, List<Integer> primes) {
        return new PrimeNumbersDto(initialValue, primes);
    }
}
