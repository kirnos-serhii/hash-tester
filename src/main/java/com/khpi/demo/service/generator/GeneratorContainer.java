package com.khpi.demo.service.generator;

import com.khpi.demo.entity.enumeration.DataGeneration;
import com.khpi.demo.service.generator.impl.RandomMackAddressGenerator;
import com.khpi.demo.service.generator.impl.SequenceMackAddressGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GeneratorContainer {

    private final Map<DataGeneration, MackAddressGenerator> mackAddressGeneratorMap = new HashMap<>();

    @Autowired
    public GeneratorContainer(
            SequenceMackAddressGenerator sequenceMackAddressGenerator,
            RandomMackAddressGenerator randomMackAddressGenerator) {
        mackAddressGeneratorMap.put(DataGeneration.RANDOM, randomMackAddressGenerator);
        mackAddressGeneratorMap.put(DataGeneration.SEQUENCE, sequenceMackAddressGenerator);
    }

    public MackAddressGenerator get(DataGeneration key) {
        return mackAddressGeneratorMap.get(key);
    }
}
