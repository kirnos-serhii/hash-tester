package com.khpi.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculationDTO {

    private long executionTime;

    private String algorithm;

    private Integer numberElements;

    private Integer numberOfCollisions;

    private Integer bits;
}
