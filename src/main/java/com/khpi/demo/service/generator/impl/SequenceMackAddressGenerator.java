package com.khpi.demo.service.generator.impl;

import com.khpi.demo.dto.CalculateDTO;
import com.khpi.demo.entity.MackAddress;
import com.khpi.demo.service.generator.MackAddressGenerator;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class SequenceMackAddressGenerator implements MackAddressGenerator {

    @Override
    public Set<MackAddress> generate(CalculateDTO calculateDTO) {
        Set<MackAddress> mackAddresses = new LinkedHashSet<>();
        MackAddress current = new MackAddress(getBytesFromString(calculateDTO.getStartAt()));
        mackAddresses.add(current);
        for(int i = 1; i < calculateDTO.getNumberElements(); i++) {
            current = current.getIncrement();
            mackAddresses.add(current);
        }
        return mackAddresses;
    }

    private static byte[] getBytesFromString(String hexString) {
        if (hexString.length() % 2 != 0) {
            hexString = "0" + hexString;
        }
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return data;
    }
}
