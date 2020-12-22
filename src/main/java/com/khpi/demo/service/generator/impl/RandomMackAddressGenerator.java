package com.khpi.demo.service.generator.impl;

import com.khpi.demo.dto.CalculateDTO;
import com.khpi.demo.entity.MackAddress;
import com.khpi.demo.service.generator.MackAddressGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

@Component
@AllArgsConstructor
public class RandomMackAddressGenerator implements MackAddressGenerator {

    private Random random;

    @Override
    public Set<MackAddress> generate(CalculateDTO calculateDTO) {
        Set<MackAddress> mackAddresses = new LinkedHashSet<>();
        while (mackAddresses.size() < calculateDTO.getNumberElements()) {
            mackAddresses.add(generateRandomMackAddress());
        }
        return mackAddresses;
    }

    private MackAddress generateRandomMackAddress() {
        byte[] bytes = new byte[MackAddress.NUMBER_BYTES];
        random.nextBytes(bytes);
        return new MackAddress(bytes);
    }

}
