package com.guru.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PrimeNumbersDto {
    private Integer initial;
    private List<Integer> primes;
}