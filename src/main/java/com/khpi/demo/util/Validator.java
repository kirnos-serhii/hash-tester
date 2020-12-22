package com.khpi.demo.util;

import com.khpi.demo.dto.CalculateDTO;
import com.khpi.demo.entity.enumeration.DataGeneration;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class Validator {

    public List<String> validate(CalculateDTO calculateDTO) {
        List<String> result = new ArrayList<>();
        if (calculateDTO.getNumberElements() == null) {
            result.add("Please, specify 'Number elements' field.");
        } else {
            if (calculateDTO.getNumberElements() <= 0) {
                result.add("The 'Start from' field can't be zero or negative.");
            }
        }
        if (calculateDTO.getDataGeneration() == DataGeneration.SEQUENCE) {
            if (!Strings.isEmpty(calculateDTO.getStartAt())) {
                boolean b = Pattern.matches("[0-9a-fA-F]{1,6}", calculateDTO.getStartAt());
                if (!b) {
                    result.add("Incorrect format field 'Start from'.");
                }
            }
        }

        return result;
    }
}
