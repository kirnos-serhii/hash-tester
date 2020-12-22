package com.khpi.demo.service.generator;

import com.khpi.demo.dto.CalculateDTO;
import com.khpi.demo.entity.MackAddress;

import java.util.Set;

public interface MackAddressGenerator {

    Set<MackAddress> generate(CalculateDTO calculateDTO);
}
