package com.khpi.demo.dto;

import com.khpi.demo.entity.enumeration.AlgorithmType;
import com.khpi.demo.entity.enumeration.CutType;
import com.khpi.demo.entity.enumeration.DataGeneration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculateDTO {

    private Integer numberElements;

    private AlgorithmType algorithm;

    private DataGeneration dataGeneration;

    /**
     * Parameter for sequence generator.
     */
    private String startAt;

    private CutType cut;
}
