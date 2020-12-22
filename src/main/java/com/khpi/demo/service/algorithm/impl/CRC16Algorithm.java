package com.khpi.demo.service.algorithm.impl;

import com.khpi.demo.entity.BytesHashCode;
import com.khpi.demo.entity.HashCode;
import com.khpi.demo.entity.MackAddress;
import com.khpi.demo.service.algorithm.Algorithm;
import com.khpi.demo.util.CRC16;
import com.khpi.demo.util.filler.ByteFiller;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class CRC16Algorithm implements Algorithm {

    private CRC16 crc16;

    @Override
    public List<HashCode> execute(Set<MackAddress> mackAddresses, ByteFiller byteFiller) {
        List<HashCode> hashCodes = new ArrayList<>();
        mackAddresses.forEach(mackAddress -> {
            hashCodes.add(new BytesHashCode(crc16.calculate(mackAddress.getAddress()), byteFiller));
        });
        return hashCodes;
    }
}
